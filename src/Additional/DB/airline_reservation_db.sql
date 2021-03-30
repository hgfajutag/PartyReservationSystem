-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2021 at 08:29 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline_reservation_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(32) NOT NULL,
  `zip` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES
(1, '1000 N 4th st ', 'Fairfiel', 'IA', '25557'),
(2, '354 Wirth Place', 'Chicago', 'IL', '567657'),
(3, '456 St Charles', 'New Orleans', 'LA', '4565676'),
(4, '34543 Clinton st ', 'Baltimore', 'MD', '25524'),
(5, '3466 Spring Field', 'Waschington', 'VA', '45561'),
(6, '1000 N 4th st ', 'Fairfiel', 'IA', '25557'),
(7, '354 Wirth Place', 'Chicago', 'IL', '567657'),
(8, '456 St Charles', 'New Orleans', 'LA', '4565676'),
(9, '34543 Clinton st ', 'Baltimore', 'MD', '25524'),
(10, '3466 Spring Field', 'Waschington', 'VA', '45561'),
(11, '1000 N 4th st ', 'Fairfiel', 'IA', '25557'),
(12, '354 Wirth Place', 'Chicago', 'IL', '567657'),
(13, '456 St Charles', 'New Orleans', 'LA', '4565676'),
(14, '34543 Clinton st ', 'Baltimore', 'MD', '25524'),
(15, '3466 Spring Field', 'Waschington', 'VA', '45561'),
(16, '3466 Spring Field', 'Waschington', 'VA', '45561'),
(17, '1000 N 4th st ', 'Fairfiel', 'IA', '25557'),
(18, '354 Wirth Place', 'Chicago', 'IL', '567657'),
(19, '456 St Charles', 'New Orleans', 'LA', '4565676'),
(20, '34543 Clinton st ', 'Baltimore', 'MD', '25524'),
(21, '3466 Spring Field', 'Waschington', 'VA', '45561');

-- --------------------------------------------------------

--
-- Table structure for table `airline`
--

CREATE TABLE `airline` (
  `id` int(11) NOT NULL,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `history` varchar(255) NOT NULL,
  `flights` int(11) NOT NULL,
  `airports` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airline`
--

INSERT INTO `airline` (`id`, `code`, `name`, `history`, `flights`, `airports`) VALUES
(1, 'B3456', 'American Airlines', 'The first airline was the German airship company DELAG, founded on 16 November 1909', 0, 0),
(2, 'A3467', 'United', 'The four oldest non-airship airlines that still exist are the Netherlands\' KLM ', 0, 0),
(3, 'C3456', 'Avianca', 'Hace ya más de 100 años, exactamente el 5 de diciembre de 1919', 0, 0),
(4, 'D4565', 'Spirit', 'In 1990, Charter One began scheduled service from Boston and Providence, Rhode Island', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `airport`
--

CREATE TABLE `airport` (
  `id` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `addressid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airport`
--

INSERT INTO `airport` (`id`, `code`, `name`, `addressid`) VALUES
(1, 'CDO', 'Airt Port Cedar Rapid', 1),
(2, 'CCH', 'Airpot Chicago', 2),
(4, 'MSY', 'Aiport New Orleans', 3),
(5, 'BTM', 'Airpot of Baltimor', 4),
(6, 'VGA', 'Airport of Virginia', 5);

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `number` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `departureTime` date NOT NULL,
  `arrivalTime` date NOT NULL,
  `departureAirportId` int(11) NOT NULL,
  `arrivalAirportId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id`, `number`, `capacity`, `departureTime`, `arrivalTime`, `departureAirportId`, `arrivalAirportId`) VALUES
(200, 'C5F7', 45, '2021-03-02', '2021-03-03', 1, 2),
(201, 'C4T9', 70, '2021-03-04', '2021-03-04', 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `typeofperson` enum('PASSENGER','AGENT','ADMIN','PILOT','CREW') NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(20) NOT NULL,
  `dateOfbirth` date NOT NULL,
  `addressId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `typeofperson`, `firstName`, `lastName`, `password`, `email`, `dateOfbirth`, `addressId`) VALUES
(1, 'PASSENGER', 'Hanna', 'Padilla', '12', 'hannap_12@gmail.com', '1989-02-02', 1),
(4, 'AGENT', 'Ayoub', 'Lachhab', '12', 'ayoub_12@gmail.com', '1995-02-02', 2),
(5, 'ADMIN', 'Juan', 'Alba', '12', 'alba_12@gmail.com', '1983-02-02', 3),
(16, 'PASSENGER', 'Oliver', 'William', '123456', 'iabarcae@yahoo.es', '1989-02-02', 5),
(17, 'PASSENGER', 'Elijah', 'Soler', '123456', 'maeillanes@hotmail.c', '1989-02-02', 6),
(18, 'PASSENGER', 'Benjamin', 'Tim', '123456', 'osabarca@hotmail.com', '1989-02-02', 7),
(19, 'PASSENGER', 'Mason', 'Charlotte', '123456', 'c_arnes@hotmail.com', '1989-02-02', 8),
(20, 'AGENT', 'Mia', 'Harper', '1234567', 'c_arnes@hotmail.com', '1989-02-02', 9),
(21, 'AGENT', 'Isabella', 'Harper', '123456', 'mapuchin@hotmail.com', '1989-02-02', 10),
(22, 'AGENT', 'Emma', 'Noah', '123456', 'aargomedo@hecsa.cl', '1989-02-02', 11),
(23, 'AGENT', 'Ethan', 'Phillips', '123456', 'aargomedo@hecsa.cl', '1989-02-02', 12),
(24, 'PILOT', 'Mason', 'Soer', '234567', 'michelebk@hotmail.co', '1989-02-02', 13),
(25, 'PILOT', 'James', 'Bonds', '123456', 'jabravot@yahoo.es', '1989-02-02', 14),
(46, 'PILOT', 'Pilar', 'Demins', '123456', 'pilardemi@hotmail.co', '1989-02-02', 16),
(47, 'PILOT', 'Wayman', 'Fann', '123456', 'fwaymann@playinstrum', '0000-00-00', 17),
(48, 'CREW', 'Katy', 'Byhx', '', 'kaby_hxc@hotmail.com', '1989-02-02', 18),
(49, 'CREW', 'Viviana', 'Vidal', '123456', 'vivianamvidal@gmail.', '1989-02-02', 19),
(50, 'CREW', 'Dilde', 'Lousi', '1234567', 'diluido3@hotmail.com', '1989-02-02', 20),
(51, 'CREW', 'Nelly', 'Cany', '123456', 'nellycandy@yahoo.com', '1989-02-02', 21);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `passengerid` int(11) NOT NULL,
  `agentid` int(11) NOT NULL,
  `confirmed` tinyint(1) NOT NULL,
  `flightsinstances` int(11) NOT NULL,
  `tickets` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `number` varchar(32) NOT NULL,
  `passengerId` int(11) NOT NULL,
  `reservationId` int(11) NOT NULL,
  `flightinstance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `airline`
--
ALTER TABLE `airline`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `airport`
--
ALTER TABLE `airport`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `addressid` (`addressid`),
  ADD KEY `addressid_2` (`addressid`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `departureAirportId` (`departureAirportId`,`arrivalAirportId`),
  ADD KEY `departureAirportId_2` (`departureAirportId`,`arrivalAirportId`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `addressId` (`addressId`),
  ADD KEY `addressId_2` (`addressId`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `passengerid` (`passengerid`,`agentid`),
  ADD KEY `passengerid_2` (`passengerid`,`agentid`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `airline`
--
ALTER TABLE `airline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `airport`
--
ALTER TABLE `airport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `flight`
--
ALTER TABLE `flight`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
