-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-04-2021 a las 07:43:45
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `party_reservation_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(32) NOT NULL,
  `zip` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `address`
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
-- Estructura de tabla para la tabla `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `addressid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `location`
--

INSERT INTO `location` (`id`, `code`, `name`, `addressid`) VALUES
(1, 'RED', 'Red', 1),
(2, 'GREEN', 'Green', 2),
(4, 'YELLOW', 'Yellow', 3),
(5, 'ORANGE', 'Orange', 4),
(6, 'BLUE', 'Blue', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `party`
--

CREATE TABLE `party` (
  `id` int(11) NOT NULL,
  `number` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `startTime` date NOT NULL,
  `endTime` date NOT NULL,
  `strlocationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `party`
--

INSERT INTO `party` (`id`, `number`, `capacity`, `startTime`, `endTime`, `strlocationId`) VALUES
(200, '500', 600, '2021-03-31', '2021-04-01', 1),
(201, '168', 200, '2021-03-31', '2021-04-01', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pass`
--

CREATE TABLE `pass` (
  `id` int(11) NOT NULL,
  `number` varchar(32) NOT NULL,
  `guestId` int(11) NOT NULL,
  `reservationId` int(11) NOT NULL,
  `partyinstance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `place`
--

CREATE TABLE `place` (
  `id` int(11) NOT NULL,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `history` varchar(255) NOT NULL,
  `partys` int(11) NOT NULL,
  `locations` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `place`
--

INSERT INTO `place` (`id`, `code`, `name`, `history`, `partys`, `locations`) VALUES
(1, 'B3456', 'Hannah\'s', 'The first place was the German airship company DELAG, founded on 16 November 1909', 0, 0),
(2, 'A3467', 'Great Spirit', 'The four oldest non-airship places that still exist are the Netherlands\' KLM ', 0, 0),
(3, 'C3456', 'Living life', 'Hace ya más de 100 años, exactamente el 5 de diciembre de 1919', 0, 0),
(4, 'D4565', 'Be Yourself', 'In 1990, Charter One began scheduled service from Boston and Providence, Rhode Island', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `guestid` int(11) NOT NULL,
  `agentid` int(11) NOT NULL,
  `confirmed` tinyint(1) NOT NULL,
  `partysinstances` int(11) NOT NULL,
  `passs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `typeofusers` enum('GUEST','HOST','ADMIN','PILOT','CREW') NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(20) NOT NULL,
  `dateOfbirth` date NOT NULL,
  `addressId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `typeofusers`, `firstName`, `lastName`, `password`, `email`, `dateOfbirth`, `addressId`) VALUES
(1, 'GUEST', 'Hanna', 'Padilla', '12', 'hannap_12@gmail.com', '1989-02-02', 1),
(4, 'HOST', 'Ayoub', 'Lachhab', '12', 'ayoub_12@gmail.com', '1995-02-02', 2),
(5, 'ADMIN', 'Juan', 'Alba', '12', 'alba_12@gmail.com', '1983-02-02', 3),
(16, 'GUEST', 'Oliver', 'William', '12', 'iabarcae@yahoo.es', '1989-02-02', 5),
(17, 'GUEST', 'Elijah', 'Soler', '12', 'maeillanes@hotmail.c', '1989-02-02', 6),
(18, 'GUEST', 'Benjamin', 'Tim', '123456', 'osabarca@hotmail.com', '1989-02-02', 7),
(19, 'GUEST', 'Mason', 'Charlotte', '123456', 'c_arnes@hotmail.com', '1989-02-02', 8),
(20, 'HOST', 'Mia', 'Harper', '12', 'c_arnes@hotmail.com', '1989-02-02', 9),
(21, 'HOST', 'Isabella', 'Harper', '12', 'mapuchin@hotmail.com', '1989-02-02', 10),
(22, 'HOST', 'Emma', 'Noah', '123456', 'aargomedo@hecsa.cl', '1989-02-02', 11),
(23, 'GUEST', 'Ethan', 'Phillips', '123456', 'aargomedo@hecsa.cl', '1989-02-02', 12),
(24, 'PILOT', 'Mason', 'Soer', '234567', 'michelebk@hotmail.co', '1989-02-02', 13),
(25, 'PILOT', 'James', 'Bonds', '123456', 'jabravot@yahoo.es', '1989-02-02', 14),
(46, 'PILOT', 'Pilar', 'Demins', '123456', 'pilardemi@hotmail.co', '1989-02-02', 16),
(47, 'PILOT', 'Wayman', 'Fann', '123456', 'fwaymann@playinstrum', '0000-00-00', 17),
(48, 'CREW', 'Katy', 'Byhx', '', 'kaby_hxc@hotmail.com', '1989-02-02', 18),
(49, 'CREW', 'Viviana', 'Vidal', '123456', 'vivianamvidal@gmail.', '1989-02-02', 19),
(50, 'CREW', 'Dilde', 'Lousi', '1234567', 'diluido3@hotmail.com', '1989-02-02', 20),
(51, 'CREW', 'Nelly', 'Cany', '123456', 'nellycandy@yahoo.com', '1989-02-02', 21);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `addressid` (`addressid`),
  ADD KEY `addressid_2` (`addressid`);

--
-- Indices de la tabla `party`
--
ALTER TABLE `party`
  ADD PRIMARY KEY (`id`),
  ADD KEY `strlocationId` (`strlocationId`);

--
-- Indices de la tabla `pass`
--
ALTER TABLE `pass`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `guestid` (`guestid`,`agentid`),
  ADD KEY `guestid_2` (`guestid`,`agentid`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `addressId` (`addressId`),
  ADD KEY `addressId_2` (`addressId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `party`
--
ALTER TABLE `party`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;

--
-- AUTO_INCREMENT de la tabla `pass`
--
ALTER TABLE `pass`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `place`
--
ALTER TABLE `place`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`addressId`) REFERENCES `users` (`addressId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
