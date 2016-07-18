#PasswordView 
[ ![Download](https://api.bintray.com/packages/subhrajyotisen/maven/PasswordView/images/download.svg) ](https://bintray.com/subhrajyotisen/maven/PasswordView/_latestVersion)
[![License](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/MIT)
[![API](https://img.shields.io/badge/API-8%2B-brightred.svg)](https://github.com/SubhrajyotiSen/PasswordView/)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-PasswordVew-green.svg)](https://android-arsenal.com/details/1/3941)

##Installation        
PasswordView is available on jcenter and be installed using

    repositories {
	    jcenter()
	}
	dependencies {
		.
		.
	    compile 'com.subhrajyotisen:library:1.1'
	}




##Screenshot
![enter image description here](http://i.imgur.com/0d7zqaO.png)

##Usage
Touch the 'eye' icon to toggle visibility of password

**XML**

    <com.subhrajyoti.passwordview.PasswordView
		    android:id="@+id/passwordView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
            
**Java**

    PasswordView passwordView = (PasswordView)findViewById(R.id.passwordView);

##Properties
**eyeTint** 
set the colour of the visibility toggle icon

    app:eyeTint=<a color resource>
or
		

    passwordView.setEyeTint(a_color_resource);

**strikeThrough**
use a strike-through across the visibility toggle icon when disabled

    passwordView.useStrikeThrough(true);
   or
		
	app:strikeThrough="true"

##License
    The MIT License (MIT)

    Copyright (c) 2014-2016 Subhrajyoti Sen
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
