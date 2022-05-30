package mumtaz.binar.kpmovieapp.data.network

import mumtaz.binar.kpmovieapp.model.credit.GetCreditResponse
import mumtaz.binar.kpmovieapp.model.detailmovie.GetDetailMovieResponse
import mumtaz.binar.kpmovieapp.model.nowplaying.GetNowPlayingResponse
import mumtaz.binar.kpmovieapp.model.popularmovie.GetPopularMovieResponse
import mumtaz.binar.kpmovieapp.model.users.GetUserResponseItem
import mumtaz.binar.kpmovieapp.model.users.PostUserResponse
import retrofit2.http.*

interface ApiService {
    //=====================Movie========================
    @GET("/3/movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") api_key: String
    ): GetPopularMovieResponse

    @GET("/3/movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): GetDetailMovieResponse

    @GET("/3/movie/{movie_id}/credits")
    suspend fun getCreditMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): GetCreditResponse


    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") api_key: String
    ): GetNowPlayingResponse

    @GET("/3/movie/{movie_id}/similar")
    suspend fun getSimilarMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): GetPopularMovieResponse

    //=====================User========================

    @GET("/users")
    suspend fun getUser(
        @Query("email") email: String
    ) : List<GetUserResponseItem>

    @POST("/users")
    suspend fun addUsers(
        @Body user : PostUserResponse
    ): GetUserResponseItem

    @PUT("/users/{id}")
    suspend fun updateUser(
        @Body user : PostUserResponse, @Path("id") id:String
    ) : GetUserResponseItem
}