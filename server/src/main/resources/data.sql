INSERT INTO game (word_to_guess, description) VALUES
    ( 'lapin', 'Description for lapin'),
    ( 'potate', 'Description for potate')
ON CONFLICT DO NOTHING;

-- INSERT INTO round (attempt, letters_searched, state, game_id) VALUES
--     ('0', '', 'ONGOING', 'e85e8eee-2a83-4387-aae6-cedbce4a270b')
-- ON CONFLICT DO NOTHING;