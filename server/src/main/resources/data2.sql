-- INSERT INTO game (word_to_guess, description) VALUES
--     ( 'mercredi', 'au milieu de la semaine'),
--     ( 'lapin', 'un petit animal très mignon')
-- ON CONFLICT DO NOTHING;

INSERT INTO round (attempt, letters_searched, state, game_id) VALUES
    ('0', '', 'ONGOING', '16e8bd91-43e5-4988-a3d1-83be6b16f4b5')
ON CONFLICT DO NOTHING;