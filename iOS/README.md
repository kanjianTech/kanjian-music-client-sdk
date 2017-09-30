## 集成准备

## 使用方法

    1.导入

        在项目中的General配置中Embedded Binaries列表里添加KSDKFramework.framework

        如果你的项目没有添加下面的依赖，请添加，如果已经添加可以忽略
        创建Cartfile，添加以下依赖
        github "Alamofire/Alamofire"
        github "Hearst-DD/ObjectMapper"
        github "krzyzanowskim/CryptoSwift"

    2.设置key和密钥

        KanjianOpenAPI.set(app_key: "you_key", app_secret: "you_secret")

    3.使用callback风格调用API

        获取音乐风格的第一页数据

        KanjianOpenAPI.genres(page: 1, count: 10) { response in
            if let list = response.value {
                print(list.count)
            } else {
                print(response.error?.localizedDescription)
            }
        }

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

## 注意事项
