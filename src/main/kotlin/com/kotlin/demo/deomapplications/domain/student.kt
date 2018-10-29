package com.kotlin.demo.deomapplications.domain

import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL

/**
 * @author devagoud
 */

@Entity
@Table
data class Student(
        @Id
        var studentId: String?=UUID.randomUUID().toString(),
        @Column var name: String,
        @Column var last: String,
        @Column var phone: String,
        @OneToOne(cascade = arrayOf(ALL))
        @JoinColumn
        var contact: Contact,
        @OneToMany(cascade = arrayOf(ALL))
        @JoinColumn
        var address: List<Address>,
        @ManyToOne(cascade = arrayOf(ALL))
        @JoinColumn
        var college:College

) : Serializable

//@Embeddable
//data class StudentId(val studentId:Int=UUID.randomUUID().variant(), val studentDepart:String):Serializable{
//    override fun equals(other: Any?): Boolean {
//
//        if(this==other)return true
//
//        if(other==null)return false
//            if(!studentId.equals(this.studentId))return false;
//        return studentDepart.equals(this.studentDepart)
//    }
//
//    override fun hashCode(): Int {
//
//        var result=studentId.hashCode()
//        result = 31*result+studentDepart.hashCode()
//        return result
//    }
//}

@Entity
@Table
data class Address(
        @Id
        var id: String?=UUID.randomUUID().toString(),
        val housenumber: String,
        val street: String,
        val villege: String,
        val mandal: String,
        val dist: String,
        val pin: Int
)

@Entity
@Table
data class Contact(
        @Id
        var id:String?=UUID.randomUUID().toString(),
        @Column
        var phoneNumber: Number,
        @Column
        var mobilenumber: String,
        @Column
        var mail: String
)
@Entity
@Table
data class College( @Id
                    var id:String?=UUID.randomUUID().toString(),
                    @Column
                    var code: String,
                    @Column
                    var collegeName: String,
                    @Column
                    var place: String)

/*class Student(){

    @Id
var id:Int=0
    var name:String?=null
    var last:String?=null

}*/

