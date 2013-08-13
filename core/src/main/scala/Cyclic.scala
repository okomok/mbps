
package okomok.mbps


object Cyclic {

    trait HasSelf {
       // def self: self = this
        //type self = this.type
    }

    object A extends HasSelf {
     //   type kool = B.type
    }

    object B extends HasSelf {
        type fool = A.type
    }

}
