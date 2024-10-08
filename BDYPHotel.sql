PGDMP         .            	    |            grantHoteldbLast    15.4    15.3     C           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            D           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            E           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            F           1262    25560    grantHoteldbLast    DATABASE     �   CREATE DATABASE "grantHoteldbLast" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = icu LOCALE = 'en_US.UTF-8' ICU_LOCALE = 'en-US';
 "   DROP DATABASE "grantHoteldbLast";
                postgres    false            �            1259    25561    feedback    TABLE     �   CREATE TABLE public.feedback (
    id uuid NOT NULL,
    comment character varying(255),
    evaluation integer NOT NULL,
    picture character varying(255),
    guest_id uuid NOT NULL,
    room_id uuid NOT NULL
);
    DROP TABLE public.feedback;
       public         heap    postgres    false            �            1259    25568    guest    TABLE     
  CREATE TABLE public.guest (
    id uuid NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    passport_number character varying(255),
    phone_number character varying(255),
    room_id uuid
);
    DROP TABLE public.guest;
       public         heap    postgres    false            �            1259    25575    room    TABLE     �   CREATE TABLE public.room (
    id uuid NOT NULL,
    description_room character varying(255),
    type_room character varying(255)
);
    DROP TABLE public.room;
       public         heap    postgres    false            �            1259    25582 
   room_guest    TABLE     Z   CREATE TABLE public.room_guest (
    room_id uuid NOT NULL,
    guest_id uuid NOT NULL
);
    DROP TABLE public.room_guest;
       public         heap    postgres    false            �            1259    25591 
   user_model    TABLE     �   CREATE TABLE public.user_model (
    id_user bigint NOT NULL,
    active boolean NOT NULL,
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.user_model;
       public         heap    postgres    false            �            1259    25600    user_model_seq    SEQUENCE     x   CREATE SEQUENCE public.user_model_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.user_model_seq;
       public          postgres    false            �            1259    25587 	   user_role    TABLE       CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    roles character varying(255),
    CONSTRAINT user_role_roles_check CHECK (((roles)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying, 'HOUSEKEEPER'::character varying])::text[])))
);
    DROP TABLE public.user_role;
       public         heap    postgres    false            :          0    25561    feedback 
   TABLE DATA           W   COPY public.feedback (id, comment, evaluation, picture, guest_id, room_id) FROM stdin;
    public          postgres    false    214   [#       ;          0    25568    guest 
   TABLE DATA           i   COPY public.guest (id, email, first_name, last_name, passport_number, phone_number, room_id) FROM stdin;
    public          postgres    false    215   �#       <          0    25575    room 
   TABLE DATA           ?   COPY public.room (id, description_room, type_room) FROM stdin;
    public          postgres    false    216   R$       =          0    25582 
   room_guest 
   TABLE DATA           7   COPY public.room_guest (room_id, guest_id) FROM stdin;
    public          postgres    false    217   �$       ?          0    25591 
   user_model 
   TABLE DATA           I   COPY public.user_model (id_user, active, password, username) FROM stdin;
    public          postgres    false    219   �$       >          0    25587 	   user_role 
   TABLE DATA           3   COPY public.user_role (user_id, roles) FROM stdin;
    public          postgres    false    218   1&       G           0    0    user_model_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_model_seq', 151, true);
          public          postgres    false    220            �           2606    25567    feedback feedback_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.feedback DROP CONSTRAINT feedback_pkey;
       public            postgres    false    214            �           2606    25574    guest guest_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.guest
    ADD CONSTRAINT guest_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.guest DROP CONSTRAINT guest_pkey;
       public            postgres    false    215            �           2606    25586    room_guest room_guest_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.room_guest
    ADD CONSTRAINT room_guest_pkey PRIMARY KEY (room_id, guest_id);
 D   ALTER TABLE ONLY public.room_guest DROP CONSTRAINT room_guest_pkey;
       public            postgres    false    217    217            �           2606    25581    room room_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    216            �           2606    25599 !   guest ukgsxbmwkq91sl41inxpjuiyvjb 
   CONSTRAINT     _   ALTER TABLE ONLY public.guest
    ADD CONSTRAINT ukgsxbmwkq91sl41inxpjuiyvjb UNIQUE (room_id);
 K   ALTER TABLE ONLY public.guest DROP CONSTRAINT ukgsxbmwkq91sl41inxpjuiyvjb;
       public            postgres    false    215            �           2606    25597    user_model user_model_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.user_model
    ADD CONSTRAINT user_model_pkey PRIMARY KEY (id_user);
 D   ALTER TABLE ONLY public.user_model DROP CONSTRAINT user_model_pkey;
       public            postgres    false    219            �           2606    25606 $   feedback fk3f6svlc0gdd8jhh1g8c9lwm8b    FK CONSTRAINT     �   ALTER TABLE ONLY public.feedback
    ADD CONSTRAINT fk3f6svlc0gdd8jhh1g8c9lwm8b FOREIGN KEY (room_id) REFERENCES public.room(id);
 N   ALTER TABLE ONLY public.feedback DROP CONSTRAINT fk3f6svlc0gdd8jhh1g8c9lwm8b;
       public          postgres    false    3489    216    214            �           2606    25621 &   room_guest fk3uwde23lyhjxrrv2uec0eif00    FK CONSTRAINT     �   ALTER TABLE ONLY public.room_guest
    ADD CONSTRAINT fk3uwde23lyhjxrrv2uec0eif00 FOREIGN KEY (room_id) REFERENCES public.room(id);
 P   ALTER TABLE ONLY public.room_guest DROP CONSTRAINT fk3uwde23lyhjxrrv2uec0eif00;
       public          postgres    false    3489    217    216            �           2606    25601 $   feedback fkj6cjgvuqyyls58wg5gixwgyi3    FK CONSTRAINT     �   ALTER TABLE ONLY public.feedback
    ADD CONSTRAINT fkj6cjgvuqyyls58wg5gixwgyi3 FOREIGN KEY (guest_id) REFERENCES public.guest(id);
 N   ALTER TABLE ONLY public.feedback DROP CONSTRAINT fkj6cjgvuqyyls58wg5gixwgyi3;
       public          postgres    false    214    3485    215            �           2606    25611 !   guest fkjodw45n0ji6awsac21kl6g28x    FK CONSTRAINT        ALTER TABLE ONLY public.guest
    ADD CONSTRAINT fkjodw45n0ji6awsac21kl6g28x FOREIGN KEY (room_id) REFERENCES public.room(id);
 K   ALTER TABLE ONLY public.guest DROP CONSTRAINT fkjodw45n0ji6awsac21kl6g28x;
       public          postgres    false    216    215    3489            �           2606    25616 &   room_guest fkrlmb9kw4we6my1vl3yy05qpqh    FK CONSTRAINT     �   ALTER TABLE ONLY public.room_guest
    ADD CONSTRAINT fkrlmb9kw4we6my1vl3yy05qpqh FOREIGN KEY (guest_id) REFERENCES public.guest(id);
 P   ALTER TABLE ONLY public.room_guest DROP CONSTRAINT fkrlmb9kw4we6my1vl3yy05qpqh;
       public          postgres    false    3485    217    215            �           2606    25626 $   user_role fkryojaj4bpgbcrlxbtdbejvwn    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkryojaj4bpgbcrlxbtdbejvwn FOREIGN KEY (user_id) REFERENCES public.user_model(id_user);
 N   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fkryojaj4bpgbcrlxbtdbejvwn;
       public          postgres    false    3493    218    219            :   }   x����0@�s2E0��8qv�b\w�n����`w�V�|�]�Y㱈Ba�2<
*�bٔ�j�׾�{�O|�o'~��T7�ڻà��u�u�|^����3�D.�V���d�~�9P%+�      ;   Z   x�M�1
�0 ��/�Ƥm�����������pwL�τN(�Ռ�2�(>����y���H��ǯb���eɛ��R�D,��� ��j      <   �   x��=!@�N�0�2�����1��u]{c��Rr#���-��Q{����~����@b}JT�xQ��j�םj��n�'���xg0n��M梽1QG
�N�B��h���}�1���,���?(�      =      x������ � �      ?   "  x�M�Kv�0  �5��5F@L��# ����y݀D	T8}}��ffr2p6���t�TU��a�<ܥST��q�����8���#>r�>�F!�mD��Tr��8�)J����ma!�����M���
>\-�QP������a�IY".�|,�ˌ�;0��a�Z��t�A���O��5�>͗�Mn��BL�D\���?����L
ޡ��}ؔ����
�=�i�T{���Z#U�8���Q^Ox6����(�̼�4�ɬ����$��1x=��|*'n��#n}�����I�?��m�      >   /   x�3�tt����2�v�25�����]]�\Cc4>T]� �&`     