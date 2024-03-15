-- CREATE EXTENSION IF NOT EXISTS pgcrypto;
--
-- INSERT INTO "user" (username, password )VALUES
--     ('lisa', crypt('lapin', gen_salt('bf'))),
--     ('admin', crypt('administrateur', gen_salt('bf')))
-- ON CONFLICT DO NOTHING ;
--
-- INSERT INTO game (word_to_guess, description, created_by) VALUES
--     ( 'mercredi', 'au milieu de la semaine', (SELECT username FROM "user" WHERE username ='lisa')),
--     ( 'lapin', 'un petit animal très mignon', (SELECT username FROM "user" WHERE username ='lisa'))
-- ON CONFLICT DO NOTHING;

INSERT INTO round (attempt, letters_searched, state, game_id) VALUES
    ('0', '', 'ONGOING', '8b24cdbe-75eb-48ad-a5a1-477966c714b2')
ON CONFLICT DO NOTHING;