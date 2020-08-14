(ns twitter-api.tweets.validation
  (:require [clojure.string :as str]
            [compojure.core :refer :all])
  (:gen-class))

(def minimum-body-length 1)
(def maximum-body-length 140)

(defn validate-tweet
  "validate if a tweet has all the required data"
  [tweet]
  (and
    (<= minimum-body-length (count (:body tweet)) maximum-body-length)
    (= 0 (str/index-of (:username tweet) "@"))
    ;(= 2 (count (str (:username tweet))))
    ))
