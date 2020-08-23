(ns twitter-api.db.db
  (:require [hugsql.core :as hugsql])
  (:gen-class))

(def db
  {:subprotocol "postgres"
   :dbtype "postgres"
   :dbname "twitter"
   :user "postgres"
   :password ""})

(hugsql/def-db-fns "twitter_api/db/sql/queries.sql")
(hugsql/def-sqlvec-fns "twitter_api/db/sql/queries.sql")

