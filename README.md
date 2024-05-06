# Word Ladder
Dibuat untuk memenuhi Tugas Kecil 3 IF2211 Strategi Algoritma Semester II Tahun 2023/2024

## Table of Contents
* [General Info](#general-information)
* [Features](#features)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Guide](#guide)
* [Project Status](#project-status)
* [Contact](#contact)


## General Information
Pada permainan Word Ladder, pemain diberikan dua kata yang disebut sebagai start word dan end word. 
Untuk memenangkan permainan, pemain harus menemukan rantai kata yang dapat menghubungkan antara start word dan end word.
Peraturannya yaitu tiap kata hanya boleh memiliki perbedaan 1 huruf. <br />
<br />
Penulis membuat program dimana program tersebut dapat mencari jalur kata dari kata start dan end menggunakan algoritma 
- Uniform Cost Search (UCS)
- Greedy Best-First Search (GBFS)
- A* (A Star) <br/>

Program diimplementasikan dalam bahasa Java.


## Features
- Mencari path optimal dengan A*
- Mengetahui jumlah node yang diperiksa untuk masing masing algoritma
- Mengetahui waktu eksekusi program


## Screenshots
![Example screenshot](./img/screenshot.png)
<!-- If you have screenshots you'd like to share, include them here. -->


## Setup
1. Clone repository ini pada link berikut:
    ```
    https://github.com/keanugonza/Tucil3_13522082.git
    ```
2. Masuk ke folder hasil clone dan buka terminal
3. Masuk ke folder src 
    ```
    cd src
    ```
4. Jalankan program
    ```
    javac Main.java
   java Main
    ```


## Project Status
Project is: _complete_ 


## Guide
1. Masukan kata start apapun, program sudah dapat memvalidasi
2. Masukan kata end apapun, program sudah dapat memvalidasi
3. Pilih kategori dari 1-3
4. Program akan menampilkan hasil
5. Program exit


## Contact
Created by Keanu Amadius Gonza Wrahatno

Contact: <br/>
13522082@std.stei.itb.ac.id <br/>
13522082@mahasiswa.itb.ac.id


<!-- Optional -->
<!-- ## License -->
<!-- This project is open source and available under the [... License](). -->

<!-- You don't have to include all sections - just the one's relevant to your project -->