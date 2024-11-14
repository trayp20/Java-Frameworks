package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
@Component
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        if (product.getId() != 0) {
            Product myProduct = repo.findById((int) product.getId());
            int inventoryChange = product.getInv() - myProduct.getInv();  // Calculating the change in inventory for the product

            for (Part p : myProduct.getParts()) {
                // Check if the inventory for any part will fall below the minimum required after manufacturing
                if ((p.getInv() - inventoryChange) < p.getMinInv()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Manufacturing this product will result in insufficient inventory for part: " + p.getName() +
                                            ". Required minimum is " + p.getMinInv() + ", but will be " + (p.getInv() - inventoryChange) + ".")
                            .addConstraintViolation();
                    return false;

                }
                // Additional validation for parts
                if (p.getInv() < p.getMinInv()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Inventory for part " + p.getName() + " is less than the minimum allowed. Minimum: " + p.getMinInv() + ", Current: " + p.getInv())
                            .addConstraintViolation();
                    return false;
                }

                if (p.getInv() > p.getMaxInv()) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(
                                    "Inventory for part " + p.getName() + " is greater than the maximum allowed. Maximum: " + p.getMaxInv() + ", Current: " + p.getInv())
                            .addConstraintViolation();
                    return false;
                }
            }
        }
            return true;

    }

}
