(ns cigoog.core
  (:require
    ;[tiltontec.cell.base :refer [ia-type ia-type?]]
    #_ [tiltontec.cell.core
     :refer-macros [c? c?+ c-reset-next! c?once c?n]
     :refer [c-in c-reset! make-cell]]
    [tiltontec.model.core :refer [*par* md-get make] :as md]
    [cigoog.types :as cgty]
    #_ [tiltontec.cigoog.base
     :refer [qxme qx-class-new qx-initialize qx-initialize-all
             app-routing]]
    ;;[tiltontec.cigoog.widget]
    ))

(defn image [source & iargs]
  (apply md/make
         ::cgty/h5.image
         :source source
         iargs))

#_
(defn button [label-icon & iargs]
  (apply md/make :type ::cgty/h5.button
         :qx-new-args (if (coll? label-icon)
                        label-icon [label-icon])
         iargs))

(defn p [value & iargs]
  (apply md/make
         :type ::cgty/h5.p
         :value value
         iargs))

(defn label [value & iargs]
  (apply md/make
         :type ::cgty/h5.label
         :value value
         iargs))

