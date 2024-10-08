package com.zoomcar.networkclient

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*
  * @created 09/01/2020 - 3:00 PM
  * @project ZC-Network-Client
  * @author Paras
*/
@Serializable
data class User(
    @SerialName("id")
    var id: Int = -1,
    @SerialName("name")
    var name: String? = null,
    @SerialName("username")
    var username: String? = null,
    @SerialName("email")
    var email: String? = null,
    @SerialName("address")
    var address: AddressVO? = null,
    @SerialName("phone")
    var phone: String? = null,
    @SerialName("website")
    var website: String? = null,
    @SerialName("company")
    var company: CompanyVO? = null
)

@Serializable
data class AddressVO(
    @SerialName("street")
    var street: String? = null,
    @SerialName("suite")
    var suite: String? = null,
    @SerialName("city")
    var city: String? = null,
    @SerialName("zipcode")
    var zipcode: String? = null,
    @SerialName("geo")
    var geo: GeoVO? = null
)

@Serializable
data class GeoVO(
    @SerialName("lat")
    var lat: String? = null,
    @SerialName("lng")
    var lng: String? = null
)

@Serializable
data class CompanyVO(
    @SerialName("name")
    var name: String? = null,
    @SerialName("catchPhrase")
    var catchPhrase: String? = null,
    @SerialName("bs")
    var bs: String? = null
)