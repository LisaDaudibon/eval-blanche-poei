#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER lisa ENCRYPTED PASSWORD 'pendu';
    CREATE DATABASE pendu_db OWNER lisa;
    GRANT ALL PRIVILEGES ON DATABASE pendu_db TO lisa;
    GRANT ALL ON schema public TO lisa;
EOSQL