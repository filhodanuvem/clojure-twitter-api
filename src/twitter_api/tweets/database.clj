(ns twitter-api.tweets.database
  (:require [twitter-api.db.db :refer :all]
            [cheshire.core :as json]
            [twitter-api.tweets.validation :as v])
  (:gen-class))

(defn post-tweet
  "Post a tweet to the audience"
  [tweet]
  (let [is-valid (v/validate-tweet tweet)]
    (if (true? is-valid)
      (do
        (sql-insert-tweet db tweet)
        true))))

(defn search-tweets-by-username
  "Find tweets from a specific username"
  [username]
  (let [result (sql-search-tweets-by-username-sqlvec db {:username (str "@" username)})]
    result))