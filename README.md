# MovieApp

You can watch movies/series and find explanations about movies/series through this application.<br>
There are hundreds of movies/series (popular, top rated, currently playing etc.)


# Major technologies
Coroutine,MVVM,Navigation Companent,live data,Retrofit,Data binding,json,Navigation draver,Glide

- `MVVM`(you can develop your project thanks to the design pattern)
- `Coroutine`(Used coroutine to retrieve data.)
- `Navigation Companen`(For a powerful application, it is necessary to use navigation. Single activity, multiple fragments.)
- `Live data`(I used three live data variables. These are the variable that holds the error, loading and data)
- `Retrofit`(You can get data from TMDB thanks to Retrofit)
- `Data binding`(i used databinding to take up less space.This way is very efficent)
- `Navigation draver`(This is important for user experience)
- `Glide`((I used glide to load the images. If the upload is "loading", it will be "circular bar". If "error", the wrong image will be shown.))
- `Youtube Api`(Used to play videos)

# Note
If you want to get data from TMDB you need to get Api key.<br>
You can get data from TMDB like this code:

```
@GET("{movie_id}")
    suspend fun getDetailFilm(@Path("movie_id") movieId:Int,
                               @Query("api_key") api_key:String,
                               @Query("language") language:String):Response<DetailFilm>

```













## CONTACT
[LinkedIn](https://www.linkedin.com/in/ishak-erdo%C4%9Fan-332b77233/)

[Instagram](https://www.instagram.com/ishakerdogan728/)
