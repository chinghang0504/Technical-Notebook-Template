# [HTML and CSS Note](../../README.md) - Chapter 10 Audios
| Chapter | Title |
| :-: | :- |
| 10.1 | [HTML5: Audios \<audio>](#101-html5-audios-audio) |
|  | [Attributes: src, controls, autoplay, preload, and loop](#attributes-src-controls-autoplay-preload-and-loop) |
| 10.2 | [HTML5: Multiple Audio Sources](#102-html5-multiple-audio-sources) |
|  | [Attribute: src](#attribute-src) |

<br />

## 10.1 HTML5: Audios \<audio>
### Attributes: src, controls, autoplay, preload, and loop
- src
    - This attribute specifies the path to the audio file.
- controls
    - This attribute indicates whether the player should display controls.
    - If you do not use this attribute, no controls will be shown by default.
    - You can also specify your own controls using JavaScript.
autoplay
    - The presence of this attribute indicates that the audio should start playing automatically. (It is considered better practice to let visitors choose to play audio.)
- preload
    - This attribute indicates what the browser should do if the player is not set to autoplay.
- loop
    - This attribute specifies that the audio track should play again once it has finished.

```html
<!DOCTYPE html>
<html>
    <body>
        <audio src="../../images/Part%20I/sample.mp3"
        controls
        autoplay>
            <p>Song</p>
        </audio>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_10_1.PNG)

<br />

### 10.2 HTML5: Multiple Audio Sources
- It is possible to specify more than one audio file using the \<source> element between the opening \<audio> and closing \</audio> tags (instead of the src attribute on the opening \<audio> tag).

### Attribute: src
- src
    - The \<source> element uses the src attribute to indicate where the audio file is located.
- type
    - At the time of writing, the type attribute was not commonly being used on the \<source> element in the same way it was for the \<video> element.

```html
<!DOCTYPE html>
<html>
    <body>
        <audio controls autoplay>
            <source src="../../images/Part%20I/sample.mp3" />
            <source src="../../images/Part%20I/sample.ogg" />
            <p>Song</p>
        </audio>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_10_2.PNG)

<br />
