(defproject reagent-devcards "0.1.0-SNAPSHOT"
  :description "Simple devcards for trying reagent"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [devcards "0.2.1"]
                 [reagent "0.6.0-alpha"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]

  :source-paths ["src"]

  :cljsbuild {
              :builds [{:id "devcards"
                        :source-paths ["src"]
                        :figwheel { :devcards true } ;; <- note this
                        :compiler { :main       "reagent-devcards.core"
                                    :asset-path "js/compiled/devcards_out"
                                    :output-to  "resources/public/js/compiled/reagent_devcards_devcards.js"
                                    :output-dir "resources/public/js/compiled/devcards_out"
                                    :source-map-timestamp true }}
                       {:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main       "reagent-devcards.core"
                                   :asset-path "js/compiled/out"
                                   :output-to  "resources/public/js/compiled/reagent_devcards.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :source-map-timestamp true }}
                       {:id "prod"
                        :source-paths ["src"]
                        :compiler {:main       "reagent-devcards.core"
                                   :asset-path "js/compiled/out"
                                   :output-to  "resources/public/js/compiled/reagent_devcards.js"
                                   :optimizations :advanced}}]}

  :figwheel { :css-dirs ["resources/public/css"] })
