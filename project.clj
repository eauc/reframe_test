(defproject reframe "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [devcards "0.2.1"]
                 [reagent "0.5.1"]
                 [binaryage/devtools "0.6.1"]
                 [re-frame "0.7.0"]
                 [secretary "1.2.3"]
                 [garden "1.3.2"]
                 [ns-tracker "0.3.0"]
                 [compojure "1.5.0"]
                 [yogthos/config "0.8"]
                 [ring "1.4.0"]]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-garden "0.2.8"]
            [lein-npm "0.5.0"]
            [lein-bower "0.5.1"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target" "node_modules"
                                    "resources/public/css" "resources/public/lib"]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler reframe.handler/dev-handler}

  :garden {:builds [{:id           "screen"
                     :source-paths ["src/cljs"]
                     :stylesheet   reframe.styles/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}

  :node-dependencies [[bower "1.7.9"]]
  :bower {:directory "resources/public/lib"}
  :bower-dependencies [[normalize.css "~4.2.0"]
                       [font-awesome "~4.6.0"]]

  :profiles
  {:dev
   {:dependencies []

    :plugins      [[lein-figwheel "0.5.4-3"]]
    }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "reframe.core/mount-root"}
     :compiler     {:main                 reframe.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true}}

    {:id           "min"
     :source-paths ["src/cljs"]
     :jar true
     :compiler     {:main            reframe.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    {:id           "devcards"
     :source-paths ["src/cljs"]
     :figwheel     { :devcards true }
     :compiler     {:main                 reframe.core
                    :output-to            "resources/public/js/compiled/reframe_devcards.js"
                    :output-dir           "resources/public/js/compiled/devcards_out"
                    :asset-path           "js/compiled/devcards_out"
                    :source-map-timestamp true }}

    {:id           "test"
     :source-paths ["src" "test"]
     :figwheel     {:on-jsload "reframe.test-runner/runner"}
     :compiler     {:main          reframe.test-runner
                    :output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test_out"
                    :optimizations :none
                    :asset-path    "js/compiled/test_out"
                    :source-map     true
                    ;; :source-map-timestamp true
                    :cache-analysis true }}

    ]}

  :main reframe.server

  :aot [reframe.server]

  :uberjar-name "reframe.jar"

  :prep-tasks [["npm" "install"]
               ["bower" "install"]
               ["cljsbuild" "once" "min"]
               ["garden" "once"]
               "compile"]
  )
