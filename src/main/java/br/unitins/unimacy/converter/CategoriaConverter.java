package br.unitins.unimacy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.unimacy.model.Categoria;

@FacesConverter(forClass = Categoria.class, value = "categoriaConverter")
public class CategoriaConverter implements Converter<Categoria>  {

		@Override
		public Categoria getAsObject(FacesContext context, UIComponent component, String value) {
			Categoria categoria = new Categoria();
			categoria.setNome(value);
			
			return categoria;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Categoria categoria) {
			return categoria.getNome();
		}
}
