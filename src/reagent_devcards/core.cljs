(ns reagent-devcards.core
  (:require
   [reagent.core :as ra]
   [reagent-devcards.components :as cs])
  (:require-macros
   [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)

(defcard title-card
  "This card is just stupid reagent static component. Created first."
  (dc/reagent cs/title-component))


(defcard clicking-card
  "Something little bit crazier. Clicking man, clicking!"
  (dc/reagent [cs/clicking-component]))

(defcard greeting-card
  "Exorbant greeting component, which will greet you!"
  (dc/reagent [cs/greeting-component]))

(defn main []
  ;; conditionally start the app based on wether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (ra/render-component [cs/working] node)))

(main)

