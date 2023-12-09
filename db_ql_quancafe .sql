

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `username` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `account` (`ID`, `username`, `password`, `name`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'huy123', '123456', 'Huy'),
(3, 'son123', '123456', 'Son');


CREATE TABLE `drinks` (
  `ID` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `start_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `invoice` (
  `ID` int(11) NOT NULL,cafeaccount
  `account_ID` int(11) NOT NULL,
  `invoice_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tables_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `total_price` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `orders` (
  `ID` int(11) NOT NULL,
  `drinks_ID` int(11) NOT NULL,
  `count` int(50) NOT NULL,
  `invoice_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `orders` (`ID`, `drinks_ID`, `count`, `invoice_ID`) VALUES
(13, 4, 1, 8),
(14, 6, 1, 8),
(15, 5, 1, 9),
(16, 7, 1, 10),
(17, 6, 1, 11),
(18, 4, 1, 11),
(19, 5, 1, 11),
(20, 7, 1, 11);

CREATE TABLE `tables` (
  `ID` int(11) NOT NULL,
  `table_name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `note` text COLLATE utf8_unicode_ci,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `tables` (`ID`, `table_name`, `note`, `status`) VALUES
(1, 'Bàn 1', '', 0),
(2, 'Bàn 2', '', 0),
(3, 'Bàn 3', '', 0),
(4, 'Bàn 4', '', 0),
(5, 'Bàn 5', 'cafeaccount', 0);


ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `drinks`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `invoice`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `account_ID` (`account_ID`),
  ADD KEY `tables_id` (`tables_id`);


ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `drinks_ID` (`drinks_ID`),
  ADD KEY `invoice_ID` (`invoice_ID`);


ALTER TABLE `tables`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `drinks`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `invoice`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

ALTER TABLE `orders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

ALTER TABLE `tables`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`account_ID`) REFERENCES `account` (`ID`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`tables_id`) REFERENCES `tables` (`ID`);

ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`drinks_ID`) REFERENCES `drinks` (`ID`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`invoice_ID`) REFERENCES `invoice` (`ID`);
