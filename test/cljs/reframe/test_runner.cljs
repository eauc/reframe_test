(ns reframe.test-runner
  (:require [reframe.core-test]
            [devtools.core :as devtools]
            [cljs.test :refer [report] :refer-macros [run-tests]]))

(enable-console-print!)
(devtools/install!)

(defn color-favicon-data-url [color]
  (let [cvs (.createElement js/document "canvas")]
    (set! (.-width cvs) 16)
    (set! (.-height cvs) 16)
    (let [ctx (.getContext cvs "2d")]
      (set! (.-fillStyle ctx) color)
      (.fillRect ctx 0 0 16 16))
    (.toDataURL cvs)))

(defn change-favicon-to-color [color]
  (let [icon (.getElementById js/document "favicon")]
    (set! (.-href icon) (color-favicon-data-url color))))

(defmethod cljs.test/report [:cljs.test/default :end-run-tests] [m]
  (if (cljs.test/successful? m)
    (change-favicon-to-color "#0d0")
    (change-favicon-to-color "#d00"))) ;;<<-- change color

(defn ^:export runner []
  (run-tests 'reframe.core-test))
