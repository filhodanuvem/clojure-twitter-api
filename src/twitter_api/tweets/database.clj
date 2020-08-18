(ns twitter-api.tweets.database
  (:require [twitter-api.db.db :refer :all]
            [twitter-api.tweets.validation :as v])
  (:gen-class))

(defn post-tweet
  "Post a tweet to the audience"
  [tweet]
  (let [is-valid (v/validate-tweet tweet)]
    (if (true? is-valid)
      (do
        (insert-tweet db tweet)
        true))))