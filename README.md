# Exemplo de Site com Spring Boot e BD

Base de dados disponível neste link:

https://github.com/cwoodruff/ChinookDatabase/tree/master/Scripts

### Destaque de alguns pontos falados em aula

- Os nomes das colunas (@Column(name="...")) têm de ser clocados em letra minúscula de outra forma spring-boot altera os nomes. Não se preocupem com o facto de não estar em letra minúscula na BD pois o sql por default não é case sensitive 
- Para ignorar mais que um atributo no JsonIgnoreProperties coloquem {} e separem os nomes por virgula: @JsonIgnoreProperties({"artist","id"})
- Não se esqueçam de que se tiverem uma ligação bidirecional têm de usar o @JsonIgnoreProperties para impedir que o JSON entre em loop (ver os atributos artist no Album e albums no Artist)
- Quando querem que uma classe vá ter uma lista ou atributo de outra a partir de uma Foreign Key o @JoinColumn(name="...") vai ter sempre o nome da coluna que é Foreign Key (o id já está sinalizado com @Id)
..- Se for uma ligação ManyToOne, temos uma lista e a FK está na própria classe e o id na outra (exemplo: Album)
..- Se for uma ligação OneToMany, temos uma variável e a FK está na outra classe e o id nesta (exemplo: Artist)
..- Se for uma ligação OneToOne depende onde é que representaram a FK, visto que ela pode ser sempre colocada em qualquer uma das classes (sem exemplo)

