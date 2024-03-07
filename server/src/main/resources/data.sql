INSERT INTO game (word_to_guess, description) VALUES
    ( 'lapin', 'Description for lapin'),
    ( 'potate', 'Description for potate'),
ON CONFLICT DO NOTHING;

INSERT INTO round (attempt, state, game_uuid) VALUES
    ('0', 'ONGOING', '93a6a0a8-25b5-4c35-92b4-4a2baa1f96cd'),
ON CONFLICT DO NOTHING;