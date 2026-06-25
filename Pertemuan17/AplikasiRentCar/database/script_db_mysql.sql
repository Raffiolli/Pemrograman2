CREATE DATABASE IF NOT EXISTS dbrentcar;
USE dbrentcar;

CREATE TABLE IF NOT EXISTS tbmobil (
    kode_mobil  VARCHAR(10)  NOT NULL PRIMARY KEY,
    nama_mobil  VARCHAR(50),
    merk        VARCHAR(30),
    tahun       INT,
    kapasitas   INT,
    harga_sewa  DOUBLE,
    status      VARCHAR(15) DEFAULT 'Tersedia'
);

CREATE TABLE IF NOT EXISTS tbcustomer (
    kode_customer VARCHAR(10) NOT NULL PRIMARY KEY,
    nama          VARCHAR(50),
    alamat        VARCHAR(100),
    no_telepon    VARCHAR(15),
    no_ktp        VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS tbsewa (
    kode_sewa           VARCHAR(15) NOT NULL PRIMARY KEY,
    kode_customer       VARCHAR(10),
    kode_mobil          VARCHAR(10),
    tgl_sewa            DATE,
    tgl_kembali_rencana DATE,
    tgl_kembali_aktual  DATE,
    lama_sewa           INT,
    total_biaya         DOUBLE,
    status              VARCHAR(15) DEFAULT 'Aktif',
    CONSTRAINT fk_sewa_customer FOREIGN KEY (kode_customer) REFERENCES tbcustomer(kode_customer),
    CONSTRAINT fk_sewa_mobil    FOREIGN KEY (kode_mobil)    REFERENCES tbmobil(kode_mobil)
);

CREATE TABLE IF NOT EXISTS tbuser (
    username VARCHAR(30) NOT NULL PRIMARY KEY,
    password VARCHAR(32),
    nama     VARCHAR(50)
);

-- User admin default (username: admin, password: admin -> MD5)
INSERT IGNORE INTO tbuser (username, password, nama)
VALUES ('admin', MD5('admin'), 'Administrator');
