<?php


namespace HuntkingdomBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * AnimalsMobile
 *
 * @ORM\Table(name="animals")
 * @ORM\Entity(repositoryClass="HuntkingdomBundle\Repository\AnimalsRepository")
 */
class AnimalsMobile
{/**
 * @var int
 *
 * @ORM\Column(name="id", type="integer")
 * @ORM\Id
 * @ORM\GeneratedValue(strategy="AUTO")
 */
    private $id;


    /**
     * @ORM\Column(name="image_name",type="string",length=255)
     *
     * @var string
     */
    private $image;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=20, nullable=true)
     */
    private $nom;


    /**
     * @var string
     *
     * @ORM\Column(name="race", type="string", length=20, nullable=true)
     */
    private $race;




    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * Set image
     * @param string $image
     *

     */
    public function setImage($image)
    {
        $this->image = $image;
    }



    /**
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @param string $nom
     */
    public function setNom($nom)
    {
        $this->nom = $nom;
    }

    /**
     * @return string
     */
    public function getRace()
    {
        return $this->race;
    }

    /**
     * @param string $race
     */
    public function setRace($race)
    {
        $this->race = $race;
    }
    /**
     * @return string
     */
    public function __toString()
    {
        return $this->nom;
    }


}