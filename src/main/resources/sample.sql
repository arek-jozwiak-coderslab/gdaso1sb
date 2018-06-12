INSERT INTO `role` (`role_id`, `role`) VALUES
  (1, '1');


INSERT INTO `users` (`id`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES
  (1, 1, '1', NULL, NULL, '1'),
  (3, 1, '2', NULL, NULL, '2');


INSERT INTO `user_role` (`user_6id`, `role_id`) VALUES
  (1, 1),
  (3, 1);
