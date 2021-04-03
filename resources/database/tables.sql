-- -------------------------------------------------------------
-- TablePlus 3.1.2(296)
--
-- https://tableplus.com/
--
-- Database: postgres
-- Generation Time: 2021-04-03 15:38:20.3830
-- -------------------------------------------------------------


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."tweets" (
    "id" uuid NOT NULL,
    "body" text NOT NULL,
    "created_at" timestamp,
    "username" varchar NOT NULL,
    PRIMARY KEY ("id")
);

