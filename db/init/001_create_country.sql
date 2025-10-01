CREATE TABLE IF NOT EXISTS "Country" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    "dialingCountryCode" VARCHAR(10) NOT NULL,
    "isoCountryCode" VARCHAR(10) NOT NULL
);
