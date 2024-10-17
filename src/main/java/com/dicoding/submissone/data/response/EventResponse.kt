package com.dicoding.submissone.data.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize // Use this annotation if you prefer Kotlin's Parcelize feature
data class EventResponse(
	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("name")
	val name: String? = null, // Nullable

	@field:SerializedName("image")
	val image: String? = null, // Nullable

	@field:SerializedName("description")
	val description: String? = null, // Nullable

	@field:SerializedName("ownerName")
	val ownerName: String? = null, // Nullable

	@field:SerializedName("beginTime")
	val beginTime: String? = null, // Nullable

	@field:SerializedName("quota")
	val quota: Int,

	@field:SerializedName("registrant")
	val registrant: Int,

	@field:SerializedName("link")
	val link: String? = null // Nullable
) : Parcelable {

	// This constructor is called when creating from a Parcel
	constructor(parcel: Parcel) : this(
		id = parcel.readString() ?: "", // Non-nullable with default value
		name = parcel.readString(), // Nullable
		image = parcel.readString(), // Nullable
		description = parcel.readString(), // Nullable
		ownerName = parcel.readString(), // Nullable
		beginTime = parcel.readString(), // Nullable
		quota = parcel.readInt(),
		registrant = parcel.readInt(),
		link = parcel.readString() // Nullable
	)

	// This method describes the kinds of special objects contained in this Parcelable instance
	override fun describeContents(): Int = 0

	// Companion object to facilitate Parcelable implementation
	companion object : Parceler<EventResponse> {

		// This method writes your object's data to the passed-in Parcel
		override fun EventResponse.write(parcel: Parcel, flags: Int) {
			parcel.writeString(id)
			parcel.writeString(name) // Nullable
			parcel.writeString(image) // Nullable
			parcel.writeString(description) // Nullable
			parcel.writeString(ownerName) // Nullable
			parcel.writeString(beginTime) // Nullable
			parcel.writeInt(quota)
			parcel.writeInt(registrant)
			parcel.writeString(link) // Nullable
		}

		override fun create(parcel: Parcel): EventResponse {
			return EventResponse(parcel)
		}
	}
}
