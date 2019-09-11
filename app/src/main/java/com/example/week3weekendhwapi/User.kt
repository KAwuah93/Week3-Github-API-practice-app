package com.example.week3weekendhwapi

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User : Parcelable {

    @SerializedName("login")
    @Expose
    var login: String? = null
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null
    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null
    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null
    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null
    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null
    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null
    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("site_admin")
    @Expose
    var isSiteAdmin: Boolean = false
    @SerializedName("name")
    @Expose
    var name: Any? = null
    @SerializedName("company")
    @Expose
    var company: String? = null
    @SerializedName("blog")
    @Expose
    var blog: String? = null
    @SerializedName("location")
    @Expose
    var location: String? = null
    @SerializedName("email")
    @Expose
    var email: Any? = null
    @SerializedName("hireable")
    @Expose
    var hireable: Any? = null
    @SerializedName("bio")
    @Expose
    var bio: String? = null
    @SerializedName("public_repos")
    @Expose
    var publicRepos: Int = 0
    @SerializedName("public_gists")
    @Expose
    var publicGists: Int = 0
    @SerializedName("followers")
    @Expose
    var followers: Int = 0
    @SerializedName("following")
    @Expose
    var following: Int = 0
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

    protected constructor(`in`: Parcel) {
        this.login = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.id = `in`.readValue(Int::class.javaPrimitiveType!!.getClassLoader()) as Int
        this.nodeId = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.avatarUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.gravatarId = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.url = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.htmlUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.followersUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.followingUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.gistsUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.starredUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.subscriptionsUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.organizationsUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.reposUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.eventsUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.receivedEventsUrl = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.type = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.isSiteAdmin = `in`.readValue(Boolean::class.javaPrimitiveType!!.getClassLoader()) as Boolean
        this.name = `in`.readValue(Any::class.java!!.getClassLoader())
        this.company = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.blog = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.location = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.email = `in`.readValue(Any::class.java!!.getClassLoader())
        this.hireable = `in`.readValue(Any::class.java!!.getClassLoader())
        this.bio = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.publicRepos = `in`.readValue(Int::class.javaPrimitiveType!!.getClassLoader()) as Int
        this.publicGists = `in`.readValue(Int::class.javaPrimitiveType!!.getClassLoader()) as Int
        this.followers = `in`.readValue(Int::class.javaPrimitiveType!!.getClassLoader()) as Int
        this.following = `in`.readValue(Int::class.javaPrimitiveType!!.getClassLoader()) as Int
        this.createdAt = `in`.readValue(String::class.java!!.getClassLoader()) as String?
        this.updatedAt = `in`.readValue(String::class.java!!.getClassLoader()) as String?
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param eventsUrl
     * @param location
     * @param publicRepos
     * @param type
     * @param blog
     * @param gravatarId
     * @param subscriptionsUrl
     * @param id
     * @param following
     * @param followers
     * @param htmlUrl
     * @param nodeId
     * @param createdAt
     * @param avatarUrl
     * @param name
     * @param followingUrl
     * @param login
     * @param starredUrl
     * @param siteAdmin
     * @param gistsUrl
     * @param url
     * @param updatedAt
     * @param followersUrl
     * @param reposUrl
     * @param hireable
     * @param bio
     * @param publicGists
     * @param email
     * @param receivedEventsUrl
     * @param company
     * @param organizationsUrl
     */
    constructor(login: String, id: Int, nodeId: String, avatarUrl: String, gravatarId: String, url: String, htmlUrl: String, followersUrl: String, followingUrl: String, gistsUrl: String, starredUrl: String, subscriptionsUrl: String, organizationsUrl: String, reposUrl: String, eventsUrl: String, receivedEventsUrl: String, type: String, siteAdmin: Boolean, name: Any, company: String, blog: String, location: String, email: Any, hireable: Any, bio: String, publicRepos: Int, publicGists: Int, followers: Int, following: Int, createdAt: String, updatedAt: String) : super() {
        this.login = login
        this.id = id
        this.nodeId = nodeId
        this.avatarUrl = avatarUrl
        this.gravatarId = gravatarId
        this.url = url
        this.htmlUrl = htmlUrl
        this.followersUrl = followersUrl
        this.followingUrl = followingUrl
        this.gistsUrl = gistsUrl
        this.starredUrl = starredUrl
        this.subscriptionsUrl = subscriptionsUrl
        this.organizationsUrl = organizationsUrl
        this.reposUrl = reposUrl
        this.eventsUrl = eventsUrl
        this.receivedEventsUrl = receivedEventsUrl
        this.type = type
        this.isSiteAdmin = siteAdmin
        this.name = name
        this.company = company
        this.blog = blog
        this.location = location
        this.email = email
        this.hireable = hireable
        this.bio = bio
        this.publicRepos = publicRepos
        this.publicGists = publicGists
        this.followers = followers
        this.following = following
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    fun withLogin(login: String): User {
        this.login = login
        return this
    }

    fun withId(id: Int): User {
        this.id = id
        return this
    }

    fun withNodeId(nodeId: String): User {
        this.nodeId = nodeId
        return this
    }

    fun withAvatarUrl(avatarUrl: String): User {
        this.avatarUrl = avatarUrl
        return this
    }

    fun withGravatarId(gravatarId: String): User {
        this.gravatarId = gravatarId
        return this
    }

    fun withUrl(url: String): User {
        this.url = url
        return this
    }

    fun withHtmlUrl(htmlUrl: String): User {
        this.htmlUrl = htmlUrl
        return this
    }

    fun withFollowersUrl(followersUrl: String): User {
        this.followersUrl = followersUrl
        return this
    }

    fun withFollowingUrl(followingUrl: String): User {
        this.followingUrl = followingUrl
        return this
    }

    fun withGistsUrl(gistsUrl: String): User {
        this.gistsUrl = gistsUrl
        return this
    }

    fun withStarredUrl(starredUrl: String): User {
        this.starredUrl = starredUrl
        return this
    }

    fun withSubscriptionsUrl(subscriptionsUrl: String): User {
        this.subscriptionsUrl = subscriptionsUrl
        return this
    }

    fun withOrganizationsUrl(organizationsUrl: String): User {
        this.organizationsUrl = organizationsUrl
        return this
    }

    fun withReposUrl(reposUrl: String): User {
        this.reposUrl = reposUrl
        return this
    }

    fun withEventsUrl(eventsUrl: String): User {
        this.eventsUrl = eventsUrl
        return this
    }

    fun withReceivedEventsUrl(receivedEventsUrl: String): User {
        this.receivedEventsUrl = receivedEventsUrl
        return this
    }

    fun withType(type: String): User {
        this.type = type
        return this
    }

    fun withSiteAdmin(siteAdmin: Boolean): User {
        this.isSiteAdmin = siteAdmin
        return this
    }

    fun withName(name: Any): User {
        this.name = name
        return this
    }

    fun withCompany(company: String): User {
        this.company = company
        return this
    }

    fun withBlog(blog: String): User {
        this.blog = blog
        return this
    }

    fun withLocation(location: String): User {
        this.location = location
        return this
    }

    fun withEmail(email: Any): User {
        this.email = email
        return this
    }

    fun withHireable(hireable: Any): User {
        this.hireable = hireable
        return this
    }

    fun withBio(bio: String): User {
        this.bio = bio
        return this
    }

    fun withPublicRepos(publicRepos: Int): User {
        this.publicRepos = publicRepos
        return this
    }

    fun withPublicGists(publicGists: Int): User {
        this.publicGists = publicGists
        return this
    }

    fun withFollowers(followers: Int): User {
        this.followers = followers
        return this
    }

    fun withFollowing(following: Int): User {
        this.following = following
        return this
    }

    fun withCreatedAt(createdAt: String): User {
        this.createdAt = createdAt
        return this
    }

    fun withUpdatedAt(updatedAt: String): User {
        this.updatedAt = updatedAt
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(login)
        dest.writeValue(id)
        dest.writeValue(nodeId)
        dest.writeValue(avatarUrl)
        dest.writeValue(gravatarId)
        dest.writeValue(url)
        dest.writeValue(htmlUrl)
        dest.writeValue(followersUrl)
        dest.writeValue(followingUrl)
        dest.writeValue(gistsUrl)
        dest.writeValue(starredUrl)
        dest.writeValue(subscriptionsUrl)
        dest.writeValue(organizationsUrl)
        dest.writeValue(reposUrl)
        dest.writeValue(eventsUrl)
        dest.writeValue(receivedEventsUrl)
        dest.writeValue(type)
        dest.writeValue(isSiteAdmin)
        dest.writeValue(name)
        dest.writeValue(company)
        dest.writeValue(blog)
        dest.writeValue(location)
        dest.writeValue(email)
        dest.writeValue(hireable)
        dest.writeValue(bio)
        dest.writeValue(publicRepos)
        dest.writeValue(publicGists)
        dest.writeValue(followers)
        dest.writeValue(following)
        dest.writeValue(createdAt)
        dest.writeValue(updatedAt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Creator<User> {


            override fun createFromParcel(`in`: Parcel): User {
                return User(`in`)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }

        }
    }

}
