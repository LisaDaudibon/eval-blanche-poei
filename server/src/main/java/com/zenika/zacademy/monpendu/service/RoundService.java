package com.zenika.zacademy.monpendu.service;

import com.zenika.zacademy.monpendu.repository.RoundRepository;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class RoundService {
    private final short MAX_NUMBER_TRIES = 10;

    private final RoundRepository roundRepository;

    private static String getRoundWord(String word, List<String> searchLetters) {
        return Arrays.stream(word.split(""))
                .map(letter -> (searchLetters).stream()
                        .anyMatch(letter::equalsIgnoreCase) ? letter : "-")
                .collect(Collectors.joining());
    }

    public List<Round> findAll () {
        return this.roundRepository.findAll();
    }

    public Round findOneById(UUID id) throws NotFoundException {
        return this.roundRepository.findById(id)
                .map(round -> {
                    round.setRoundWord(getRoundWord(round.getGame().getWordToGuess(), round.getLettersSearched()));
                    return round;
                }).orElseThrow(NotFoundException::new);
    }


    public Round guessedLetter (UUID id, String letter) throws NotFoundException {
        Round round = this.findOneById(id);

        /**
         * Check the status of the game
         */
        if (round.getState().equalsIgnoreCase("ONGOING")) {
            /**
             * add the letter to the list if not in it
             */
            if (!round.getLettersSearched().contains(letter)) {
                round.getLettersSearched().add(letter);
            }

            String oldWord = round.getRoundWord();
            /**
             * add the letter to the word to guess if necessary
             */
            round.setRoundWord(getRoundWord(round.getGame().getWordToGuess(), round.getLettersSearched()));

            /**
             * check if the letter is in the word, if not increment attempts
             */
            if (oldWord.equalsIgnoreCase(round.getRoundWord())) {
                round.setAttempt(round.getAttempt() + 1 );
            }
        }

        /**
         * set state of the round
         */
        if (!round.getRoundWord().contains("-")) {
            round.setState("WIN");
        } else if (round.getAttempt() >= MAX_NUMBER_TRIES) {
            round.setState("LOST");
        }

        this.roundRepository.save(round);

        return round;
    }
}
