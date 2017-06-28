(ns cigoog.base
  (:require
    [clojure.set :refer [union difference]]
    [tiltontec.util.base :refer [prog1]]
    [tiltontec.util.core :refer [pln ensure-vec fifo-data fifo-clear]]
    [tiltontec.cell.base
     :refer [unbound ia-type ia-type?
             +client-q-handler+] :as cty]
    [tiltontec.cell.integrity
     :refer-macros [with-integrity] :as md]
    [tiltontec.cell.observer :refer [observe +observe-default-handler+]]
    [tiltontec.model.base :refer [md-awaken-before]
     :as mdb]
    [tiltontec.model.core :refer [md-get md-getx md-reset!]]
    [cigoog.types :as cgty]
    [clojure.string :as str]
    [goog.dom :as dom]))

(defn cg-type-to-h5-tag [type]
  (str/replace (str type) #"^:cigoog.types/h5." ""))

(defn cg-tag-new [type iargs]
  (if-let [tag (or (:tag iargs)
                   (cg-type-to-h5-tag type))]
      (do
        (pln :making :tag!!!!! type  :tag tag :args iargs)
        (dom/createDom tag nil))
      (throw (js/Error. (str "qx-class-new does not know about " type)))))

(def js-app (atom nil))