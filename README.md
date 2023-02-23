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


# Screenshots

![photo1677171358](https://user-images.githubusercontent.com/91196350/221007088-b6f39395-5f1a-48d4-8ca2-44d68e31559b.jpeg)
![photo1677171358 (1)](https://user-images.githubusercontent.com/91196350/221007106-f6c4c5f9-ba6e-4126-8020-b70db19b6cd8.jpeg)
![photo1677171358 (2)](https://user-images.githubusercontent.com/91196350/221007116-21034d87-4d17-4ef3-a94c-97581f71c285.jpeg)
![photo1677171358 (3)](https://user-images.githubusercontent.com/91196350/221007061-c303d4c7-8d31-4827-af53-cf90de1d77ca.jpeg)<br><br><br>
### Here you can read about film<br><br><br>
![photo1677171358 (4)](https://user-images.githubusercontent.com/91196350/221007072-7ffb9b5a-3464-4d2d-9171-8cb40696782b.jpeg)<br><br><br>
### Here you can watch film<br><br><br>
![photo1677171358 (6)](https://user-images.githubusercontent.com/91196350/221007083-81398e55-94ae-4ab3-a064-ba45342f645a.jpeg)












# CONTACT
[LinkedIn](https://www.linkedin.com/in/ishak-erdo%C4%9Fan-332b77233/)

[Instagram](https://www.instagram.com/ishakerdogan728/)
