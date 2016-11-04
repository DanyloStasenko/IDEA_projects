import models.Product;
import models.ProductCategory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class Main
{
    public static void main(String[] args)
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Product product = new Product();
        product.setTitle("qw");
        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);

        for (ConstraintViolation<Product> constraintViolation : constraintViolations)
        {
            StringBuilder stringBuilder = new StringBuilder("property: ");
            stringBuilder.append(constraintViolation.getPropertyPath());
            stringBuilder.append("value: ");
            stringBuilder.append(constraintViolation.getInvalidValue());
            stringBuilder.append("message: ");
            stringBuilder.append(constraintViolation.getMessage());

            System.out.println(stringBuilder.toString());
        }

    }
}