INSERT INTO `db_bidding`.`tbl_roles` VALUES (1, "ADMIN", "An admin can do anything.");
INSERT INTO `db_bidding`.`tbl_roles` VALUES (2, "SELLER", "A seller can sell but not bid.");
INSERT INTO `db_bidding`.`tbl_roles` VALUES (3, "BIDDER", "A bidder bid but not sell.");

INSERT INTO `db_bidding`.`tbl_users` VALUES (1, "admin", "admin123", "Mr. Administrator", "admin@fpt.com", 1);
INSERT INTO `db_bidding`.`tbl_users` VALUES (2, "seller", "seller123", "Mrs. Seller", "seller@fpt.com", 2);
INSERT INTO `db_bidding`.`tbl_users` VALUES (3, "bidder", "bidder123", "Miss. Bidder", "bidder@fpt.com", 3);
INSERT INTO `db_bidding`.`tbl_users` VALUES (4, "jstrange", "jstrange", "Jennifer Strange", "jstrange@fpt.com", 2);
INSERT INTO `db_bidding`.`tbl_users` VALUES (5, "hpotter", "hpotter", "Harry Potter", "hpotter@fpt.com", 3);

INSERT INTO `db_bidding`.`tbl_items` VALUES (1, "huggies", "super diaper", 2, NOW(), "2015-05-22 00:00:00", 30.45);
INSERT INTO `db_bidding`.`tbl_items` VALUES (2, "huggies", "super diaper", 2, NOW(), "2015-05-22 00:00:00", 130.00);
INSERT INTO `db_bidding`.`tbl_items` VALUES (3, "pampers", "for babies and adults", 4, NOW(), "2015-08-03 00:00:00", 50.35);
INSERT INTO `db_bidding`.`tbl_items` VALUES (4, "whisper", "with wings and more", 4, NOW(), "2015-08-20 00:00:00", 20.00);
INSERT INTO `db_bidding`.`tbl_items` VALUES (5, "modess", "cool clean comfy", 2, NOW(), "2015-06-12 00:00:00", 50.00);
INSERT INTO `db_bidding`.`tbl_items` VALUES (6, "sister", "approved by Sarah Geronimo", 2, NOW(), "2015-09-01 00:00:00", 1000.00);

INSERT INTO `db_bidding`.`tbl_bids` VALUES (1, 1, 3, 0.0, 0.0, NOW());
INSERT INTO `db_bidding`.`tbl_bids` VALUES (2, 2, 5, 0.0, 0.0, NOW());
INSERT INTO `db_bidding`.`tbl_bids` VALUES (3, 3, 3, 0.0, 0.0, NOW());
INSERT INTO `db_bidding`.`tbl_bids` VALUES (4, 4, 5, 0.0, 0.0, NOW());