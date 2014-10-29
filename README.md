android-typography
===============

### Download

Clone the repository and import as Android Library in eclipse or grab via maven or gradle:

##### Maven
```xml
<dependency>
    <groupId>com.github.pidygb</groupId>
    <artifactId>typography</artifactId>
    <version>(insert latest version)</version>
</dependency>
```
##### Gradle
```groovy
dependencies {
   compile 'com.github.pidygb:typography:+'
}
```
### Usage

*For a working implementation of this project see the `sample/` folder.*

#### Views

Use the following views in your xml:

```xml
<com.github.pidygb.android.widget.Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="text"
    app:typeface="Ubuntu-Regular.ttf"
    app:scaleLetterSpacing="2.5"
    app:textUpperCase="true"/>

<com.github.pidygb.android.widget.EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:inputType="text"
    app:typeface="Ubuntu-Regular.ttf"/>
        
<com.github.pidygb.android.widget.TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Ubuntu Regular font"
    app:typeface="Ubuntu-Regular.ttf"
    app:scaleLetterSpacing="2.5"
    app:textUpperCase="true"/>
```

##### When:

* `app:typeface` : A font file present in ***assets/fonts*** folder
* `app:scaleLetterSpacing` : A scale factor for letter spacing
* `app:textUpperCase` : force the text in uppercase

## License

    Copyright 2014 Giuseppe Buzzanca

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
