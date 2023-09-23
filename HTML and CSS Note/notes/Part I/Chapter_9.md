# [HTML and CSS Note](../../README.md) - Chapter 9 Videos
| Chapter | Title |
| :-: | :- |
| 9.1 | [HTML5: Videos \<video>](#91-html5-videos-video) |
|  | [Attributes: src, poster, width, height, proload, controls, autoplay, and loop](#attributes-src-poster-width-height-proload-controls-autoplay-and-loop) |
| 9.2 | [HTML5: Multiple Video Sources \<video> and \<source>](#92-html5-multiple-video-sources-video-and-source) |
|  | [Attributes: src and type](#attributes-src-and-type) |

<br />

## 9.1 HTML5: Videos \<video>
### Attributes: src, poster, width, height, proload, controls, autoplay, and loop
- src
    - This attribute specifies the path to the video. (The example video is in H264 format so it will only work in IE and Safari.)
- poster
    - This attribute allows you to specify an image to show while the video is downloading or until the user tells the video to play.
- width, height
    - These attributes specify the size of the player in pixels.
- preload
    - This attribute tells the browser what to do when the page loads.
    - It can have one of three values:
        1. none
            - The browser should not load the video until the user presses play.
        2. auto
            - The browser should download the video when the page loads.
        3. metadata
            - The browser should just collect information such as the size, first frame, track list, and duration.
- controls
    - When used, this attribute indicates that the browser should supply its own controls for playback.
- autoplay
    - When used, this attribute specifies that the file should play automatically.
- loop
    - When used, this attribute indicates that the video should start playing again once it has ended.

```html
<!DOCTYPE html>
<html>
    <body>
        <video src="../../images/Part%20I/sample.mp4"
            poster="../../images/Part%20I/earth.jpg"
            width="400" height="300"
            preload="none"
            controls
            loop>
            <p>Earth</p>
        </video>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_9_1.PNG)

<br />

## 9.2 HTML5: Multiple Video Sources \<video> and \<source>
- To specify the location of the file to be played, you can use the \<source> element inside the \<video> element. (This should replace the src attribute on the opening \<video> tag.)
- You can also use multiple \<source> elements to specify that the video is available in different formats.

### Attributes: src and type
- src
    - This attribute specifies the path to the video.
- type
    - You should use this attribute to tell the browser what format the video is.
    - Otherwise, it will download some of the video to see if it can play the file (which will take time and bandwidth).

```html
<!DOCTYPE html>
<html>
    <body>
        <video poster="../../images/Part%20I/earth.jpg"
            width="400" height="300"
            preload="none"
            controls
            loop>
            <source src="../../images/Part%20I/sample.mp4"
                type='video/mp4' />
            <source src="../../images/Part%20I/sample.webm"
                type='video/webm' />
            <p>Earth</p>
        </video>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_9_2.PNG)

<br />
