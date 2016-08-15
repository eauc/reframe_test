(ns reframe.test-runner
  (:require [reframe.core-test]
            [cljs.test :refer-macros [run-tests]]))

;; (doo-tests 'reframe.core-test)
(enable-console-print!)

;; (defn ^:export run
;;   []
;;   (run-all-tests #"reframe.core-test"))
(defn ^:export runner []
  (run-tests 'reframe.core-test))
