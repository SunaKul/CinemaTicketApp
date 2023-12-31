package reyhansunakul_hw1

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
//sıkıntı burda olabilir

class Customer : Parcelable{
    var seatNumber: String?

    //primary constructor
    constructor(name: String?) {
        this.seatNumber = name
    }


    override fun toString(): String {
        return "Customer's {" +
                "seat no/s: ='" + seatNumber +
                '}'
    }

    //secondary consrtuctor
    protected constructor(`in`: Parcel) {
        seatNumber = `in`.readString()
    }
    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(seatNumber)
    }
    override fun describeContents(): Int {
        return 0
    }

    fun memberMethod() {
        println("Member method called")
    }

    //companian object
    companion object CREATOR : Parcelable.Creator<Customer> {
        override fun createFromParcel(parcel: Parcel): Customer {
            return Customer(parcel)
        }

        override fun newArray(size: Int): Array<Customer?> {
            return arrayOfNulls(size)
        }

        fun staticMethod() {
            println("Static method called")
        }
    }

}