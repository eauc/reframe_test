(ns reframe.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [reframe.core-test]))

(doo-tests 'reframe.core-test)
