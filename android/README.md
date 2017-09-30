## 集成准备

## 使用方法

    1.build.gradle 配置

        compile(name:'kanjian_openapi', ext:'aar')

        如果你的项目没有添加下面的依赖，请添加，如果已经添加可以忽略

        compile 'io.reactivex.rxjava2:rxjava:2.1.3'
        compile 'com.squareup.retrofit2:converter-gson:2.3.0'
        compile 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
        compile 'com.squareup.retrofit2:retrofit:2.3.0'

    2.设置key和密钥

        KanjianOpenAPI.init(this.getApplicationContext(), "you_key", "you_secret");

        或者设置自定义的全局默认的pagecount

        KanjianOpenAPI.init(this.getApplicationContext(), "you_key", "you_secret"，20);

    3.使用rxjava风格调用API

        获取音乐风格的第一页数据

        KanjianOpenAPI.genres(0).subscribe(new Consumer<KList<KGenre>>() {
            @Override
            public void accept(KList<KGenre> kGenreKList) throws Exception {
            }
        });

        获取音乐风格的第一页数据，传入自定义的pagecount

        KanjianOpenAPI.genres(0, 20).subscribe(new Consumer<KList<KGenre>>() {
            @Override
            public void accept(KList<KGenre> kGenreKList) throws Exception {
            }
        });

    4.使用callback风格调用API

        获取音乐风格的第一页数据

        KanjianOpenAPI.genres(0, new Callback<KList<KGenre>>() {
            @Override
            public void onFailure(Throwable e) {
            }

            @Override
            public void onSuccess(KList<KGenre> kGenreKList) {
            }
        });

        获取音乐风格的第一页数据，传入自定义的pagecount

        KanjianOpenAPI.genres(0, 20, new Callback<KList<KGenre>>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                    }

                    @Override
                    public void onSuccess(KList<KGenre> kGenreKList) {
                    }
                });

## API 数据接口

    1.音乐风格

        KanjianOpenAPI.genres，获取风格
        KanjianOpenAPI.genreAlbums，通过风格获取专辑
        KanjianOpenAPI.genreTracks，根据风格获取单曲列表

    2.音乐人

        KanjianOpenAPI.artists，获取音乐人
        KanjianOpenAPI.artistAlbums，通过音乐人获取专辑
        KanjianOpenAPI.artistTracks，根据音乐人获取单曲

    3.专辑

        KanjianOpenAPI.album，获取专辑
        KanjianOpenAPI.albumTracks，根据专辑获取单曲

    4.单曲

        KanjianOpenAPI.track，获取单曲
        KanjianOpenAPI.audition，获取单曲试听地址

    5.搜索接口

        KanjianOpenAPI.searchArtists，搜索音乐人
        KanjianOpenAPI.searchAlbums，搜索专辑
        KanjianOpenAPI.searchTracks，搜索单曲

## ProGuard

    -keep class com.kanjian.openapi.** { *; }
    -keep class io.reactivex.Single

## 注意事项