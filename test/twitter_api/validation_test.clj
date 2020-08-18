(ns twitter-api.validation-test
  (:require [clojure.test :refer :all]
            [twitter-api.tweets.validation :refer :all]))

(deftest validation-test
  (testing "Should be valid"
    (is (true? (validate-tweet {:body "this is my frist tweet"
                     :username  "@filhodanuvem"}))))

  (testing "Should fail when there is no body"
    (is (false? (validate-tweet {:body ""
                     :username  "@filhodanuvem"}))))

  (testing "Should fail when there is no username"
    (is (false? (validate-tweet {:body "this is my first tweet"
                                 :username  ""})))))