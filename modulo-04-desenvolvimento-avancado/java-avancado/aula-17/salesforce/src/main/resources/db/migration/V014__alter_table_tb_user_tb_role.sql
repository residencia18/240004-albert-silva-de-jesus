alter table if exists tb_user_role 
  add constraint FKa68196081fvovjhkek5m97n3y 
  foreign key (role_id) 
references tb_role;