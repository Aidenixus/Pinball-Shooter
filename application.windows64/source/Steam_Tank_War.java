import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Steam_Tank_War extends PApplet {

// Final Version
// Created by Minxuan Song
// Instructor Matthias D\u00f6rfelt 
// All music created by Minxuan Song using Logic Pro X.
// Citations included in the codes



SoundFile fileM, file1, file2, file3, button1, button2, button3, hit1, hit2, hit3, boom, punch;
PImage startscreen, selectscreen, steamTankP, LoHP, totoroP, leoP, handgunnersP, howlP, C1, C2, C3, C4, C5, C6, Boom, hurt;
PImage B1, B2, B3, B4, B5, B6;
PImage Ba1, Ba2, Ba3, Ba4, Ba5, Ba6;
PFont title, subtitle, loading, explanation, explanationT, explanations, loadings, music;
int screenx, screeny, stage, character1, character2, frameloading, mtimer, sx, sy, HP1c, HP2c;
float p1x, p1y, p2x, p2y, b1x, b1y, b2x, b2y, control1, control2;
float speed1, speed2, speed3, speed4, speed5, speed6, speed7, speed8, speed9, speed10, speed11, speed12;
//HP
int HP1 = 160;
int HP2 = 100;
int HP3 = 300;
int HP4 = 100;
int HP5 = 60;
int HP6 = 200;
//Attack
int At1 = 10;
int At2 = 45;
int At3 = 5;
int At4 = 15;
int At5 = 50;
int At6 = 8;
int Atc1;
int Atc2;
int count = 1; 
// count of the characters


// classes of characters
class mySteamTank1 {

  public void display() {
    p1x = p1x + control1;
    image(C1, p1x, p1y, 0.18f*height, 0.18f*height);
  }
}

class myLoH1 {
  public void display() {
    p1x = p1x + control1;
    image(C2, p1x, p1y, 0.18f*height, 0.18f*height);
  }
}

class myTotoro1 {
  public void display() {
    p1x = p1x + control1;
    image(C3, p1x, p1y, 0.23f*height, 0.23f*height);
  }
}

class myLeo1 {
  public void display() {
    p1x = p1x + control1;
    image(C4, p1x, p1y, 0.15f*height, 0.15f*height);
  }
}

class myHandgunners1 {
  public void display() {
    p1x = p1x + 5*control1;
    image(C5, p1x, p1y, 0.3f*height, 0.12f*height);
  }
}

class myHowl1 {
  public void display() {
    p1x = p1x + control1;
    image(C6, p1x, p1y, 0.25f*height, 0.25f*height);
  }
}

class mySteamTank2 {
  public void display() {
    p2x = mouseX;
    image(C1, p2x, p2y, 0.18f*height, 0.18f*height);
  }
}

class myLoH2 {
  public void display() {
    p2x = mouseX;
    image(C2, p2x, p2y, 0.18f*height, 0.18f*height);
  }
}

class myTotoro2 {
  public void display() {
    p2x = mouseX;
    image(C3, p2x, p2y, 0.23f*height, 0.23f*height);
  }
}

class myLeo2 {
  public void display() {
    p2x = mouseX;
    image(C4, p2x, p2y, 0.15f*height, 0.15f*height);
  }
}

class myHandgunners2 {
  public void display() {
    p2x = mouseX;
    image(C5, p2x, p2y, 0.3f*height, 0.12f*height);
  }
}

class myHowl2 {
  public void display() {
    p2x = mouseX;
    image(C6, p2x, p2y, 0.25f*height, 0.25f*height);
  }
}

// classes of bullets
// I need to design different types of bullets
// these classes are created so that I can make differences

class myBullet1 {
  public void display() {
    speed1 = 40;
    b1y = b1y - speed1;
    image(B1, b1x, b1y, 20, 20);
  }
}

class myBullet2 {
  public void display() {
    speed2 = 50;
    b1y = b1y - speed2;
    image(B2, b1x, b1y, 20, 20);
  }
}

class myBullet3 {
  public void display() {
    speed3 = 20;
    b1y = b1y - speed3;
    image(B3, b1x, b1y, 20, 20);
  }
}

class myBullet4 {
  public void display() {
    speed4 = 30;
    b1y = b1y - speed4;
    image(B4, b1x, b1y, 20, 20);
  }
}

class myBullet5 {
  public void display() {
    speed5 = 50;
    b1y = b1y - speed5;
    image(B5, b1x, b1y, 20, 20);
  }
}

class myBullet6 {
  public void display() {
    speed6 = 25;
    b1y = b1y - speed6;
    image(B6, b1x, b1y, 20, 20);
  }
}

class myBullet7 {
  public void display() {
    speed7 = 40;
    b2y = b2y + speed7;
    image(B1, b2x, b2y, 20, 20);
  }
}

class myBullet8 {
  public void display() {
    speed8 = 50;
    b2y = b2y + speed8;
    image(B2, b2x, b2y, 20, 20);
  }
}

class myBullet9 {
  public void display() {
    speed9 = 20;
    b2y = b2y + speed9;
    image(B3, b2x, b2y, 20, 20);
  }
}

class myBullet10 {
  public void display() {
    speed10 = 30;
    b2y = b2y + speed10;
    image(B4, b2x, b2y, 20, 20);
  }
}

class myBullet11 {
  public void display() {
    speed11 = 50;
    b2y = b2y + speed11;
    image(B5, b2x, b2y, 20, 20);
  }
}

class myBullet12 {
  public void display() {
    speed12 = 25;
    b2y = b2y + speed12;
    image(B6, b2x, b2y, 20, 20);
  }
}


myBullet1[] bullet1;
myBullet2[] bullet2;
myBullet3[] bullet3;
myBullet4[] bullet4;
myBullet5[] bullet5;
myBullet6[] bullet6;
myBullet7[] bullet7;
myBullet8[] bullet8;
myBullet9[] bullet9;
myBullet10[] bullet10;
myBullet11[] bullet11;
myBullet12[] bullet12;
mySteamTank1[] steamTank1;
myLoH1[] loH1;
myTotoro1[] totoro1;
myLeo1[] leo1;
myHandgunners1[] handgunners1;
myHowl1[] howl1;
mySteamTank2[] steamTank2;
myLoH2[] loH2;
myTotoro2[] totoro2;
myLeo2[] leo2;
myHandgunners2[] handgunners2;
myHowl2[] howl2;


public void setup() {
  mtimer = millis();
  // timer
  stage = 1;
  
  //fullScreen();
  startscreen = loadImage("miyazaki.jpg"); // by Albert Bierstadt, from https://www.artstation.com/artwork/howls-moving-castle-at-staubbach-falls-switzerland
  selectscreen = loadImage("Tang House.jpg"); // by Anonymous, from http://archive-media-1.nyafuu.com/wg/image/1367/23/1367239635610.jpg
  title = loadFont("Chalkduster-48.vlw");
  subtitle = loadFont("AmericanTypewriter-26.vlw");
  loading = loadFont("AmericanTypewriter-Bold-20.vlw");
  music = loadFont("AmericanTypewriter-Bold-12.vlw");
  explanationT = loadFont("AmericanTypewriter-Bold-25.vlw");
  loadings = loadFont("AmericanTypewriter-Bold-12.vlw");
  explanation = loadFont("Serif-20.vlw");
  explanations = loadFont("Serif-12.vlw");
  fileM = new SoundFile(this, "intro.mp3"); 
  file1 = new SoundFile(this, "f1.mp3"); 
  file2 = new SoundFile(this, "f2.mp3"); 
  file3 = new SoundFile(this, "f3.mp3"); 
  button1 = new SoundFile(this, "button-21.wav"); // from https://www.soundjay.com/button-sounds-3.html
  button2 = new SoundFile(this, "button-22.wav"); // from https://www.soundjay.com/button-sounds-3.html
  button3 = new SoundFile(this, "button-23.wav"); // from https://www.soundjay.com/button-sounds-3.html
  hit1 = new SoundFile(this, "button-24.wav"); // from https://www.soundjay.com/button-sounds-3.html
  hit2 = new SoundFile(this, "button-25.wav"); // from https://www.soundjay.com/button-sounds-3.html
  hit3 = new SoundFile(this, "button-26.wav"); // from https://www.soundjay.com/button-sounds-3.html
  boom = new SoundFile(this, "Bomb_Exploding-Sound_Explorer-68256487.mp3"); // from http://soundbible.com/tags-explosion.html
  punch = new SoundFile(this, "punch.mp3"); // from http://soundbible.com/tags-explosion.html
  steamTankP = loadImage("Empire's Steam Tank.jpg"); // from https://www.pinterest.com/pin/442478732117337269/
  LoHP = loadImage("Luminark of Hysh.png"); // from http://warhammerfantasy.wikia.com/wiki/Luminark_of_Hysh
  totoroP = loadImage("Totoro.jpg"); // from http://studioghiblimovies.com/my-neighbor-totoro/
  leoP = loadImage("Leonardo's Archetype.jpg"); // from https://www.pinterest.com/hoogbegaafd/da-vinci/
  handgunnersP = loadImage("Handgunners.jpg"); // from http://shyuechou.blogspot.com/2005/09/handgunner-medieval-handgunner.html
  howlP = loadImage("Howl's Moving Castle.jpg"); // from https://www.pinterest.com/Nyctophilia913/howls-moving-castle/
  C1 = loadImage("C1.png"); // by Denab Range, from http://prepsage.deviantart.com/art/Steam-Tank-66131970
  C2 = loadImage("C2.png"); // from http://miniset.net/sets/gw-99120202033
  C3 = loadImage("C3.png"); // from https://s-media-cache-ak0.pinimg.com/originals/b6/64/2d/b6642de3ecb4c4c9c754336ce91889b7.jpg
  C4 = loadImage("C4.png"); // from https://www.pinterest.com/hoogbegaafd/da-vinci/
  C5 = loadImage("C5.png"); // from http://miniset.net/sets/foundry/medieval/all/archers-crossbowmen-and-handgunners
  C6 = loadImage("C6.png"); // by "RedOfPaw", from http://redofpaw.deviantart.com/art/Howls-Moving-Castle-in-3D-Close-up-Side-461220796
  B1 = loadImage("Cannonball B1.png"); // from http://ru.fallout.wikia.com/wiki/\u041f\u0443\u0448\u0435\u0447\u043d\u043e\u0435_\u044f\u0434\u0440\u043e
  B2 = loadImage("mega-laser-1 B2.png"); // by "donaldcarling", from https://donaldcarling.wordpress.com/2016/03/10/star-strike-game-build/
  B3 = loadImage("509894_1 B3.png"); // from https://mobile.twitter.com/miyazaki_ru/status/603846515740778496/photo/1
  B4 = loadImage("images B4.png"); // from https://free3d.com/3d-model/arrow-pack-sample-14504.html
  B5 = loadImage("bullet B5.png"); // from http://wallpaper-gallery.net/single/bullet-image/bullet-image-6.htmlhttp://wallpaper-gallery.net/single/bullet-image/bullet-image-6.html
  B6 = loadImage("smoke B6.png"); // from http://mastereffect.blogspot.com/2013/02/cloud-brushes-effects.html
  Ba1 = loadImage("Ba1.jpg"); // from http://www.wallpaperswide.us/hd-fantasy-painting-landscape-wallpaper/
  Ba2 = loadImage("Ba2.jpg"); // from https://www.pinterest.com/gabrielhperegri/mythology/
  Ba3 = loadImage("Ba3.jpg"); // by "droemmare", from http://droemmare.deviantart.com/art/Totoro-wallpaper-292094861
  Ba4 = loadImage("Ba4.jpg"); // from http://thedali.org/event/dali-beyond-film-series-castle-in-the-sky/
  Ba5 = loadImage("Ba5.jpg"); // "Battle of Eylau", from https://gottmituns.net/tag/franco-prussian-war/
  Ba6 = loadImage("Ba6.jpg"); // from http://wallpapers.fansshare.com/gallery/photos/14024623/howl-moving-castle-calcifer/?displaying
  Boom = loadImage("Boom!.png"); // from https://www.redbubble.com/shop/comicbook+stickers
  hurt = loadImage("hurt.png"); // from http://www.clipartkid.com/free-starburst-blank-clip-art-at-clker-com-vector-clip-art-online-FWxEn8-clipart/
  HP1c = 1;
  HP2c = 1;
  sx = 1;
  sy = 1;
  character1 = 99;
  character2 = 99;
  p1y = 0.8f*height;
  p2y = 0.01f*height;
  p1x = 0.5f*width;
  p2x = 0.5f*width;
  control1 = 0;
  b1y = height;
  b2y = 0;
  
  steamTank1 = new mySteamTank1[count];
  for (int i = 0; i < count; i++) {
    steamTank1[i] = new mySteamTank1();
  }
  loH1 = new myLoH1[count];
  for (int i = 0; i < count; i++) {
    loH1[i] = new myLoH1();
  }
  totoro1 = new myTotoro1[count];
  for (int i = 0; i < count; i++) {
    totoro1[i] = new myTotoro1();
  }
  leo1 = new myLeo1[count];
  for (int i = 0; i < count; i++) {
    leo1[i] = new myLeo1();
  }
  handgunners1 = new myHandgunners1[count];
  for (int i = 0; i < count; i++) {
    handgunners1[i] = new myHandgunners1();
  }
  howl1 = new myHowl1[count];
  for (int i = 0; i < count; i++) {
    howl1[i] = new myHowl1();
  }
  //p2
  steamTank2 = new mySteamTank2[count];
  for (int i = 0; i < count; i++) {
    steamTank2[i] = new mySteamTank2();
  }
  loH2 = new myLoH2[count];
  for (int i = 0; i < count; i++) {
    loH2[i] = new myLoH2();
  }
  totoro2 = new myTotoro2[count];
  for (int i = 0; i < count; i++) {
    totoro2[i] = new myTotoro2();
  }
  leo2 = new myLeo2[count];
  for (int i = 0; i < count; i++) {
    leo2[i] = new myLeo2();
  }
  handgunners2 = new myHandgunners2[count];
  for (int i = 0; i < count; i++) {
    handgunners2[i] = new myHandgunners2();
  }
  howl2 = new myHowl2[count];
  for (int i = 0; i < count; i++) {
    howl2[i] = new myHowl2();
  }
  //bullets
  bullet1 = new myBullet1[count];
  for (int i = 0; i < count; i++) {
    bullet1[i] = new myBullet1();
  }
  bullet2 = new myBullet2[count];
  for (int i = 0; i < count; i++) {
    bullet2[i] = new myBullet2();
  }
  bullet3 = new myBullet3[count];
  for (int i = 0; i < count; i++) {
    bullet3[i] = new myBullet3();
  }
  bullet4 = new myBullet4[count];
  for (int i = 0; i < count; i++) {
    bullet4[i] = new myBullet4();
  }
  bullet5 = new myBullet5[count];
  for (int i = 0; i < count; i++) {
    bullet5[i] = new myBullet5();
  }
  bullet6 = new myBullet6[count];
  for (int i = 0; i < count; i++) {
    bullet6[i] = new myBullet6();
  }
  bullet7 = new myBullet7[count];
  for (int i = 0; i < count; i++) {
    bullet7[i] = new myBullet7();
  }
  bullet8 = new myBullet8[count];
  for (int i = 0; i < count; i++) {
    bullet8[i] = new myBullet8();
  }
  bullet9 = new myBullet9[count];
  for (int i = 0; i < count; i++) {
    bullet9[i] = new myBullet9();
  }
  bullet10 = new myBullet10[count];
  for (int i = 0; i < count; i++) {
    bullet10[i] = new myBullet10();
  }
  bullet11 = new myBullet11[count];
  for (int i = 0; i < count; i++) {
    bullet11[i] = new myBullet11();
  }
  bullet12 = new myBullet12[count];
  for (int i = 0; i < count; i++) {
    bullet12[i] = new myBullet12();
  }
}


public void draw() {
  // fade in effect
  tint(frameCount*10, 255);
  image(startscreen, 0, 0, width, height);
  noTint();
  if (stage == 1) {
    if (frameCount == 5) {
      fileM.loop();
    }
    scale(1);
    textAlign(CENTER);
    noStroke();
    fill(255, 255, 255);
    textFont(title);
    text("STEAM TANK WAR", (0.5f)*width, (0.7f)*height);
    fill(220+(35*(sin(frameCount))), 185, 220+(35*(sin(frameCount))));
    textFont(subtitle);
    if (frameCount >= 50) {
      text("Press any key to start the game", (0.5f)*width, (0.7f)*height + 50);
    }
    if (keyPressed == true && frameCount >= 50) {
      button3.play();
      stage = 2;
      mtimer = millis();
    }
  }
  if (stage == 2) {
    background(255, 0, 0);
    textFont(loading);
    fill(255);
    text("Loading...", width-100, height-20);
    textFont(music);
    text("Original Music by Minxuan Song", width-600, height-10);
    if (millis() - mtimer >= 2000) {
      // timer in action
      mtimer = millis();
      stage = 3;
    }
  }
  if (stage == 3) {
    // explanation part
    image(selectscreen, 0, 0, width, height);
    textFont(explanations);
    text("Far on a distant land, there was an emperor greedy of natrual resources.", 0.5f*width, 0.4f*height);
    text("Endless exploitation of Earth and his ambition had offended a lot of people.", 0.5f*width, 0.45f*height);
    text("Thus, a war thereby begins.", 0.5f*width, 0.5f*height);
    text("Deprived of peace, even the most unlikely combatant joined the fray.", 0.5f*width, 0.55f*height);
    if (millis() - mtimer >= 12000) {
      stage = 4;
    }
  }
  if (stage == 4) {
    // character choosing page
    image(selectscreen, 0, 0, width, height);
    textFont(loadings);
    text("Press 'w' 'a' 's' 'd' to select, press 'e' to choose for player 1, press 'k' to choose for player 2.", width*0.5f, height-20);
    imageMode(CORNER);
    image(steamTankP, width/6, height/15, width/8, height/3);
    image(LoHP, width/2.4f, height/15, width/8, height/3);
    image(totoroP, width/1.5f, height/15, width/8, height/3);
    image(leoP, width/6, height/2.3f, width/8, height/3);
    image(handgunnersP, width/2.4f, height/2.3f, width/8, height/3);
    image(howlP, width/1.5f, height/2.3f, width/8, height/3);
    if (key == 'd') {
      if (keyPressed == true) {
        button1.play();
        sx += 1;
      }
    }
    if (key == 'a') {
      if (keyPressed == true) {
        button1.play();
        sx -= 1;
      }
    }
    if (key == 'w') {
      if (keyPressed == true) {
        button1.play();
        sy -= 1;
      }
    }
    if (key == 's') {
      if (keyPressed == true) {
        button1.play();
        sy += 1;
      }
    }
    if (sx == 4) {
      sx = 1;
    }
    if (sx == 0) {
      sx = 3;
    }
    if (sy == 3) {
      sy = 1;
    }
    if (sy == 0) {
      sy = 2;
    }
    if (sx == 1 && sy == 1) {
      // steamtank
      textFont(explanationT);
      text("Empire's Steam Tank", (0.5f)*width, (0.85f)*height);
      textFont(explanations);
      text("'Tis the iron pride of the Empire of Man, soldiers' will, and Emperor Augustus' favorite form of transportation.", (0.5f)*width, (0.9f)*height);
      tint(0, 153+(sin(frameRate)*30), 204);
      image(steamTankP, width/6, height/15, width/8, height/3);
      if (keyPressed == true && key == 'e') {
        Atc1 = At1;
        button2.play();
        character1 = 1;
      }
      if (keyPressed == true && key == 'k') {
        Atc2 = At1;
        button2.play();
        character2 = 1;
      }
    }
    if (sx == 2 && sy == 1) {
      // LoHP
      textFont(explanationT);
      text("War Machine of the Crystal Sages", (0.5f)*width, (0.85f)*height);
      textFont(explanations);
      text("A war machine of the ancient developed by the scholars of the Grand Archive. Horridly destructive if exceptionally slow.", (0.5f)*width, (0.9f)*height);
      tint(0, 153+(sin(frameCount)*30), 204);
      image(LoHP, width/2.4f, height/15, width/8, height/3);
      // in this case two players can choose regardless of order
      if (keyPressed == true && key == 'e') {
        Atc1 = At2;
        character1 = 2;
        button2.play();
      }
      if (keyPressed == true && key == 'k') {
        Atc2 = At2;
        character2 = 2;
        button2.play();
      }
    }
    if (sx == 3 && sy == 1) {
      // totoro
      textFont(explanationT);
      text("Totoro", (0.5f)*width, (0.85f)*height);
      textFont(explanations);
      text("Not exactly sure what he can do, but he seems like a good neighbor.", (0.5f)*width, (0.9f)*height);
      tint(0, 153+(sin(frameCount)*30), 204);
      image(totoroP, width/1.5f, height/15, width/8, height/3);
      if (keyPressed == true && key == 'e') {
        Atc1 = At3;
        character1 = 3;
        button2.play();
      }
      if (keyPressed == true && key == 'k') {
        Atc2 = At3;
        character2 = 3;
        button2.play();
      }
    }
    if (sx == 1 && sy == 2) {
      // Da Vinci
      textFont(explanationT);
      text("Leonardo's Combat Car", (0.5f)*width, (0.85f)*height);
      textFont(explanations);
      text("Da Vinci's talents are conspicuously showed in his wondrous inventions, such as this wooden Croque-Madame.", (0.5f)*width, (0.9f)*height);
      tint(0, 153+(sin(frameCount)*30), 204);
      image(leoP, width/6, height/2.3f, width/8, height/3);
      if (keyPressed == true && key == 'e') {
        Atc1 = At4;
        character1 = 4;
        button2.play();
      }
      if (keyPressed == true && key == 'k') {
        Atc2 = At4;
        character2 = 4;
        button2.play();
      }
    }
    if (sx == 2 && sy == 2) {
      // Handgunner
      textFont(explanationT);
      text("Handgunners", (0.5f)*width, (0.85f)*height);
      textFont(explanations);
      text("Unus pro omnibus, omnes pro uno. A solitary handgunner is no threat to even the most ragamuffin plebs, provided his cohorts are not present.", (0.5f)*width, (0.9f)*height);
      tint(0, 153+(sin(frameCount)*30), 204);
      image(handgunnersP, width/2.4f, height/2.3f, width/8, height/3);
      if (keyPressed == true && key == 'e') {
        Atc1 = At5;
        character1 = 5;
        button2.play();
      }
      if (keyPressed == true && key == 'k') {
        Atc2 = At5;
        character2 = 5;
        button2.play();
      }
    }
    if (sx == 3 && sy == 2) {
      // Howl
      textFont(explanationT);
      text("Howl's Moving Castle", (0.5f)*width, (0.85f)*height);
      textFont(explanations);
      text("Let love and kindness be! When duty calls, this piece of junk also joins the brawl, and it will keep fighting until peace is found.", (0.5f)*width, (0.9f)*height);
      tint(0, 153+(sin(frameCount)*30), 204);
      image(howlP, width/1.5f, height/2.3f, width/8, height/3);
      if (keyPressed == true && key == 'e') {
        Atc1 = At6;
        character1 = 6;
        button2.play();
      }
      if (keyPressed == true && key == 'k') {
        Atc2 = At6;
        character2 = 6;
        button2.play();
      }
    }

    //info printing
    //player1
    if (character1 == 1) {
      // setting up the health
      HP1c = HP1;
      text("Player1 is Empire's Steam Tank!", 0.5f*width, 0.05f*height);
    }
    if (character1 == 2) {
      HP1c = HP2;
      text("Player1 is War Machine of the Crystal Sages!", 0.5f*width, 0.05f*height);
    }
    if (character1 == 3) {
      HP1c = HP3;
      text("Player1 is Totoro!", 0.5f*width, 0.05f*height);
    }
    if (character1 == 4) {
      HP1c = HP4;
      text("Player1 is Leonardo's Combat Car!", 0.5f*width, 0.05f*height);
    }
    if (character1 == 5) {
      HP1c = HP5;
      text("Player1 is Handgunners!", 0.5f*width, 0.05f*height);
    }
    if (character1 == 6) {
      HP1c = HP6;
      text("Player1 is Howl's Moving Castle!", 0.5f*width, 0.05f*height);
    }

    //player2
    if (character2 == 1) {
      HP2c = HP1;
      text("Player2 is Empire's Steam Tank!", 0.5f*width, 0.05f*height);
    }
    if (character2 == 2) {
      HP2c = HP2;
      text("Player2 is War Machine of the Crystal Sages!", 0.5f*width, 0.05f*height);
    }
    if (character2 == 3) {
      HP2c = HP3;
      text("Player2 is Totoro!", 0.5f*width, 0.05f*height);
    }
    if (character2 == 4) {
      HP2c = HP4;
      text("Player2 is Leonardo's Combat Car!", 0.5f*width, 0.05f*height);
    }
    if (character2 == 5) {
      HP2c = HP5;
      text("Player2 is Handgunners!", 0.5f*width, 0.05f*height);
    }
    if (character2 == 6) {
      HP2c = HP6;
      text("Player2 is Howl's Moving Castle!", 0.5f*width, 0.05f*height);
    }

    // stage detecting
    if (character1 >0 && character1 < 7 && character2 >0 && character2<7) {
      // music changing
      if (character1 ==1) {
        fileM.stop();
        file1.loop();
      }
      if (character1 ==2) {
        fileM.stop();
        file2.loop();
      }
      if (character1 ==3) {
        fileM.stop();
        file3.loop();
      }
      if (character1 ==4) {
        fileM.stop();
        file1.loop();
      }
      if (character1 ==5) {
        fileM.stop();
        file2.loop();
      }
      if (character1 ==6) {
        fileM.stop();
        file3.loop();
      }

      mtimer = millis();
      noTint();
      stage = 5;
    }
  }

  if (stage == 5) {
    textFont(loading);
    if (keyPressed == true && key == 'a') {
      control1 = -10.0f;
    }
    if (keyPressed == true && key == 'd') {
      control1 = 10.0f;
    }
    if (keyPressed == true && key =='q' && b1y <= 0.05f*height) {
      // press q to shoot
      hit1.play();
      b1x = p1x;
      b1y = p1y;
    }
    if (mousePressed == true && b2y >= 0.95f*height) {
      // press mouse to shoot
      hit2.play();
      b2x = p2x;
      b2y = p2y;
    }

    //for C1

    if (character1 == 1) {
      image(Ba1, 0, 0, width, height);
      for (int i = 0; i<count; i++) {
        steamTank1[i].display();
        bullet1[i].display();
      }
      if ((b2y >= (0.85f*height)) && (b2y <= height) && (b2x - p1x <= (0.18f*height)) && (b2x - p1x >= 0)) {
        // judgement of how much damage suffered
        HP1c = HP1c - Atc2;
        image(hurt, p1x, p1y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character1 == 2) {
      image(Ba2, 0, 0, width, height);
      for (int i = 0; i<count; i++) {
        loH1[i].display();
        bullet2[i].display();
      }
      if ((b2y >= (0.85f*height)) && (b2y <= height) && (b2x - p1x <= (0.18f*height)) && (b2x - p1x >= 0)) {
        HP1c = HP1c - Atc2;
        image(hurt, p1x, p1y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character1 == 3) {
      image(Ba3, 0, 0, width, height);
      for (int i = 0; i<count; i++) {
        totoro1[i].display();
        bullet3[i].display();
      }
      if ((b2y >= (0.85f*height)) && (b2y <= height) && (b2x - p1x <= (0.23f*height)) && (b2x - p1x >= 0)) {
        HP1c = HP1c - Atc2;
        image(hurt, p1x, p1y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character1 == 4) {
      image(Ba4, 0, 0, width, height);
      for (int i = 0; i<count; i++) {
        leo1[i].display();
        bullet4[i].display();
      }
      if ((b2y >= (0.85f*height)) && (b2y <= height) && (b2x - p1x <= (0.15f*height)) && (b2x - p1x >= 0)) {
        HP1c = HP1c - Atc2;
        image(hurt, p1x, p1y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character1 == 5) {
      image(Ba5, 0, 0, width, height);
      for (int i = 0; i<count; i++) {
        handgunners1[i].display();
        bullet5[i].display();
      }
      if ((b2y >= (0.85f*height)) && (b2y <= height) && (b2x - p1x <= (0.3f*height)) && (b2x - p1x >= 0)) {
        HP1c = HP1c - Atc2;
        image(hurt, p1x, p1y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character1 == 6) {
      image(Ba6, 0, 0, width, height);
      for (int i = 0; i<count; i++) {
        howl1[i].display();
        bullet6[i].display();
      }
      if ((b2y >= (0.85f*height)) && (b2y <= height) && (b2x - p1x <= (0.25f*height)) && (b2x - p1x >= 0)) {
        HP1c = HP1c - Atc2;
        image(hurt, p1x, p1y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }

    // for C2

    if (character2 == 1) {
      for (int j = 0; j<count; j++) {
        steamTank2[j].display();
        bullet7[j].display();
      }
      if ((b1y <= (0.15f*height)) && (b1y >= 0) && (b1x - p2x <= (0.18f*height)) && (b1x - p2x >= 0) ) {
        HP2c = HP2c - Atc1;
        image(hurt, p2x, p2y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character2 == 2) {
      for (int j = 0; j<count; j++) {
        loH2[j].display();
        bullet8[j].display();
      }
      if ((b1y <= (0.15f*height)) && (b1y >= 0) && (b1x - p2x <= (0.18f*height)) && (b1x - p2x >= 0) ) {
        HP2c = HP2c - Atc1;
        image(hurt, p2x, p2y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character2 == 3) {
      for (int j = 0; j<count; j++) {
        totoro2[j].display();
        bullet9[j].display();
      }
      if ((b1y <= (0.15f*height)) && (b1y >= 0) && (b1x - p2x <= (0.23f*height)) && (b1x - p2x >= 0) ) {
        HP2c = HP2c - Atc1;
        image(hurt, p2x, p2y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character2 == 4) {
      for (int j = 0; j<count; j++) {
        leo2[j].display();
        bullet10[j].display();
      }
      if ((b1y <= (0.15f*height)) && (b1y >= 0) && (b1x - p2x <= (0.15f*height)) && (b1x - p2x >= 0) ) {
        HP2c = HP2c - Atc1;
        image(hurt, p2x, p2y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character2 == 5) {
      for (int j = 0; j<count; j++) {
        handgunners2[j].display();
        bullet11[j].display();
      }
      if ((b1y <= (0.15f*height)) && (b1y >= 0) && (b1x - p2x <= (0.3f*height)) && (b1x - p2x >= 0) ) {
        HP2c = HP2c - Atc1;
        image(hurt, p2x, p2y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }
    if (character2 == 6) {
      for (int j = 0; j<count; j++) {
        howl2[j].display();
        bullet12[j].display();
      }
      if ((b1y <= (0.15f*height)) && (b1y >= 0) && (b1x - p2x <= (0.25f*height)) && (b1x - p2x >= 0) ) {
        HP2c = HP2c - Atc1;
        image(hurt, p2x, p2y, 0.08f*height, 0.08f*height);
        punch.play();
      }
    }

    text(HP1c, 0.1f*width, 0.4f*height);
    text(HP2c, 0.9f*width, 0.4f*height);

    if (HP2c <= 0) {
      image(Boom, p2x, p2y, 0.15f*height, 0.15f*height);
      boom.play();
      mtimer = millis();
      stage = 6;
    }
    if (HP1c <= 0) {
      image(Boom, p1x, p1y, 0.15f*height, 0.15f*height);
      boom.play();
      mtimer = millis();
      stage = 7;
    }

  } // stage 5 ends
  if (stage == 6) {
    file1.stop();
    file2.stop();
    file3.stop();
    if (millis() - mtimer >= 500) {
      background(0, 0, 0);
      textFont(loading);
      text("Player 1 wins!", 0.5f*width, 0.5f*height);
    }
    if (millis() - mtimer >= 1000) {
      textFont(explanations);
      text("Restarting the game...", 0.5f*width, 0.95f*height);
    }
    if (millis() - mtimer >= 4000) {
      character1 = 99;
      character2 = 99;
      stage = 4;
    }
  }
  // for these two stages, set up a loop so that it can return to stage 4
  if (stage == 7) {
    file1.stop();
    file2.stop();
    file3.stop();
    if (millis() - mtimer >= 500) {
      background(0, 0, 0);
      textFont(loading);
      text("Player 2 wins!", 0.5f*width, 0.5f*height);
    }
    if (millis() - mtimer >= 1500) {
      textFont(explanations);
      text("Restarting the game...", 0.5f*width, 0.95f*height);
    }
    if (millis() - mtimer >= 4000) {
      character1 = 99;
      character2 = 99;
      stage = 4;
    }
  }
} //setup ends
  public void settings() {  size(720, 405);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Steam_Tank_War" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
