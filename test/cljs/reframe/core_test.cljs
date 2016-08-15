(ns reframe.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [reframe.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= { :id 1 } { :id 1 }))))
