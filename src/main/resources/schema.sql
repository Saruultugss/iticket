-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2023 at 07:36 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iticket`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_surname` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_order`
--

CREATE TABLE IF NOT EXISTS `customer_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `order_time` timestamp NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
  `delivery_address` varchar(255) DEFAULT NULL,
  `delivery_email_address` varchar(255),
  `preferred_delivery_time` timestamp NULL DEFAULT NULL,
  `time_paid` timestamp NULL DEFAULT NULL,
  `time_sent` timestamp NULL DEFAULT NULL,
  `total_price` decimal(10,2) NULL,
  `discount` decimal(10,2) NULL,
  `final_price` decimal(10,2) NULL,
  PRIMARY KEY (`id`),
  KEY `customer_order_customer_ibfk_1` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(255) NOT NULL,
  `event_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `event_time` time NOT NULL,
  `duration` int(4) NOT NULL,
  `venue_name` varchar(500) NOT NULL,
  `address` varchar(500) NOT NULL,
  `online` bit(1) NOT NULL,
  `category` varchar(20) NOT NULL,
  `created_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `created_by` (`created_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `event_detail`
--

CREATE TABLE IF NOT EXISTS `event_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `concert_id` int(11) NOT NULL,
  `cover` varchar(2083) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `concert_id` (`concert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_ticket`
--

CREATE TABLE IF NOT EXISTS `order_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_order_id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_ticket_ticket_ibfk_1` (`ticket_id`),
  KEY `order_ticket_customer_order_ibfk_1` (`customer_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(255) DEFAULT NULL,
  `event_id` int(11) NOT NULL,
  `ticket_category_id` int(11) NOT NULL,
  `purchase_date` timestamp NULL,
  PRIMARY KEY (`id`),
  KEY `ticket_concert_ibfk_1` (`event_id`),
  KEY `ticket_ticket_category_ibfk_1` (`ticket_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ticket_category`
--

CREATE TABLE IF NOT EXISTS `ticket_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `event_id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `amount` int(6) DEFAULT NULL,
  `max` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ticket_category_concert_ibfk_1` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;