alter table if exists tb_product_category 
  add constraint FKgbof0jclmaf8wn2alsoexxq3u 
  foreign key (product_id) 
  references tb_product;